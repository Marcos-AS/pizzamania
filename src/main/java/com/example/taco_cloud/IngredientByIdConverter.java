package com.example.taco_cloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.taco_cloud.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    public IngredientByIdConverter() {
        ingredientMap.put("TOHA", new Ingredient("TOHA", "Tortilla de harina", Type.MASA));
        ingredientMap.put("TOMA", new Ingredient("TOHA", "Tortilla de maíz", Type.MASA));
        ingredientMap.put("CAPI", new Ingredient("TOHA", "Carne picada", Type.PROTEINA));
        ingredientMap.put("CARN", new Ingredient("TOHA", "Carnitas", Type.PROTEINA));
        ingredientMap.put("TMTE", new Ingredient("TOHA", "Tomate en cubos", Type.VEGETAL));
        ingredientMap.put("LECH", new Ingredient("TOHA", "Lechuga", Type.VEGETAL));
        ingredientMap.put("CHED", new Ingredient("TOHA", "Cheddar", Type.QUESO));
        ingredientMap.put("MRJA", new Ingredient("TOHA", "Monterey Jack", Type.QUESO));
        ingredientMap.put("SLSA", new Ingredient("TOHA", "Salsa", Type.SALSA));
        ingredientMap.put("CRAG", new Ingredient("TOHA", "Crema agria", Type.SALSA));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
