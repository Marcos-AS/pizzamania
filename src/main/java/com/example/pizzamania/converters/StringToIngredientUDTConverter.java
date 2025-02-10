package com.example.pizzamania.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.pizzamania.repositories.IngredientRepository;
import com.example.pizzamania.udts.IngredientUDT;
import com.example.pizzamania.udts.PizzaUDRUtils;

@Component
public class StringToIngredientUDTConverter implements Converter<String, IngredientUDT> {
    private final IngredientRepository ingredientRepository;

    public StringToIngredientUDTConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String source) {
        return ingredientRepository.findById(source).map(PizzaUDRUtils::toIngredientUDT)
        .orElseThrow(() -> new IllegalArgumentException("No se encontró el ingrediente " + source));
    }
}
