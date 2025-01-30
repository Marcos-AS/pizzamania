package com.example.taco_cloud;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.taco_cloud.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder") //mantiene al objeto tacoOrder durante la sesión
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("TOHA", "Tortilla de harina", Type.MASA),
            new Ingredient("TOMA", "Tortilla de maíz", Type.MASA),
            new Ingredient("CAPI", "Carne picada", Type.PROTEINA),
            new Ingredient("CARN", "Carnitas", Type.PROTEINA),
            new Ingredient("TMTE", "Tomate en cubos", Type.VEGETAL),
            new Ingredient("LECH", "Lechuga", Type.VEGETAL),
            new Ingredient("CHED", "Cheddar", Type.QUESO),
            new Ingredient("MRJA", "Queso Monterey Jack", Type.QUESO),
            new Ingredient("SLSA", "Salsa", Type.SALSA),
            new Ingredient("CRAG", "Crema agria", Type.SALSA)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
    
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
