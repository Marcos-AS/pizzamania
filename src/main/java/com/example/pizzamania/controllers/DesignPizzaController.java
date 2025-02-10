package com.example.pizzamania.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.pizzamania.Ingredient;
import com.example.pizzamania.Pizza;
import com.example.pizzamania.PizzaOrder;
import com.example.pizzamania.Ingredient.Type;
import com.example.pizzamania.repositories.IngredientRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/crear")
@SessionAttributes("pizzaOrder") //mantiene al objeto pizzaOrder durante la sesión
public class DesignPizzaController {

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    //los métodos con @ModelAttribute se invocan cuando se maneja una petición
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                             filterByType((List<Ingredient>) ingredients, type));
            //agrega los ingredientes como atributo del obj Model al que
            //tiene acceso la vista (servlet request)
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
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
            // System.out.println(errors);
            // System.out.println("PIZZA: " + pizza);
            return "design";
        }
        pizza.setPizzaOrder(pizzaOrder);
        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza); //el log es de SLF4J
        return "redirect:/orders/current";
    }
}