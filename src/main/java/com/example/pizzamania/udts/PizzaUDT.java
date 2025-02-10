package com.example.pizzamania.udts;

import java.util.List;

import lombok.Data;

@Data
public class PizzaUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}