package com.example.pizzamania;

public class PizzaUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("El ingrediente no puede ser nulo");
        }

        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }
}
