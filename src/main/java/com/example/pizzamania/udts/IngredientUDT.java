package com.example.pizzamania.udts;

import com.example.pizzamania.Ingredient;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class IngredientUDT {
    private final String name;
    private final Ingredient.Type type;
}