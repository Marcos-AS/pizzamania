package com.example.pizzamania;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.Data;

@Data
@UserDefinedType("pizza")
public class PizzaUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}