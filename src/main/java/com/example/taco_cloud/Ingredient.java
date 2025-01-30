package com.example.taco_cloud;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        MASA, PROTEINA, VEGETAL, QUESO, SALSA
    }
}


