package com.example.pizzamania;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.pizzamania.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/crear")
@SessionAttributes("pizzaOrder") //mantiene al objeto pizzaOrder durante la sesión
public class DesignPizzaController {

    //los métodos con @ModelAttribute se invocan cuando se maneja una petición
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("QUMO", "Queso Mozzarella", Type.QUESO),
            new Ingredient("QUPR", "Queso Provolone", Type.QUESO),
            new Ingredient("QUPA", "Queso Parmesano", Type.QUESO),
            new Ingredient("QURO", "Queso Roquefort", Type.QUESO),
            new Ingredient("QUCA", "Queso de cabra", Type.QUESO),
            new Ingredient("PRPO", "Pollo", Type.PROTEINA),
            new Ingredient("PRPA", "Panceta", Type.PROTEINA),
            new Ingredient("PRAN", "Anchoas", Type.PROTEINA),
            new Ingredient("PRCP", "Carne picada", Type.PROTEINA),
            new Ingredient("PRHU", "Huevo", Type.PROTEINA),
            new Ingredient("VECE", "Cebolla", Type.VEGETAL),
            new Ingredient("VETP", "Tomate perita", Type.VEGETAL),
            new Ingredient("VETC", "Tomate cherry", Type.VEGETAL),
            new Ingredient("VERU", "Rúcula", Type.VEGETAL),
            new Ingredient("VEES", "Espinaca", Type.VEGETAL),
            new Ingredient("VEBE", "Berenjena", Type.VEGETAL),
            new Ingredient("VEZU", "Zucchini", Type.VEGETAL),
            new Ingredient("VECH", "Choclo", Type.VEGETAL),
            new Ingredient("FRAN", "Ananá", Type.FRUTA),
            new Ingredient("FRMA", "Manzana", Type.FRUTA),
            new Ingredient("EXOR", "Orégano", Type.EXTRA),
            new Ingredient("EXAJ", "Ají molido", Type.EXTRA),
            new Ingredient("EXAO", "Aceite de oliva", Type.EXTRA),
            new Ingredient("EXMI", "Miel", Type.EXTRA),
            new Ingredient("EXNU", "Nueces", Type.EXTRA)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                             filterByType(ingredients, type));
            //agrega los ingredientes como atributo del obj Model al que
            //tiene acceso la vista (servlet request)
        }
    }

    
    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order() {
        return new PizzaOrder(); //se coloca dentro del Model y además se mantiene durante la sesión
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizza() {
        return new Pizza(); //se coloca dentro del Model
    }

    @GetMapping
    public String showDesignForm() {
        return "design"; //devuelve el nombre de la vista
    }

    @PostMapping
    //la anotación @ModelAttribute le indica que debería usar el obj PizzaOrder
    //que se ubicó en el Model mediante el método order()
    //tiene sentido al manejar las peticiones POST
    public String processPizza(@Valid Pizza pizza, Errors errors,
                                @ModelAttribute PizzaOrder pizzaOrder) {
        //los campos en el form se ligan con propiedades del objeto Pizza
        //como los checkboxes pueden ser varios seleccionados, el atr. es un List<Ingredient>
        //pero como no matchean los tipos hay que usar una clase Converter
        if (errors.hasErrors()) {
            return "design";
        }
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza); //el log es de SLF4J
        return "redirect:/orders/current";
    }
    
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
