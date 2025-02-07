package com.example.pizza_cloud;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.pizza_cloud.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    //convierte el string que llega del form en un objeto Ingredient
    public IngredientByIdConverter() {
        ingredientMap.put("QUMO", new Ingredient("QUMO", "Queso Mozzarella", Type.QUESO));
        ingredientMap.put("QUPR", new Ingredient("QUPR", "Queso Provolone", Type.QUESO));
        ingredientMap.put("QUPA", new Ingredient("QUPA", "Queso Parmesano", Type.QUESO));
        ingredientMap.put("QURO", new Ingredient("QURO", "Queso Roquefort", Type.QUESO));
        ingredientMap.put("QUCA", new Ingredient("QUCA", "Queso de cabra", Type.QUESO));
        ingredientMap.put("PRPO", new Ingredient("PRPO", "Pollo", Type.PROTEINA));
        ingredientMap.put("PRPA", new Ingredient("PRPA", "Panceta", Type.PROTEINA));
        ingredientMap.put("PRAN", new Ingredient("PRAN", "Anchoas", Type.PROTEINA));
        ingredientMap.put("PRCP", new Ingredient("PRCP", "Carne picada", Type.PROTEINA));
        ingredientMap.put("PRHU", new Ingredient("PRHU", "Huevo", Type.PROTEINA));
        ingredientMap.put("VECE", new Ingredient("VECE", "Cebolla", Type.VEGETAL));
        ingredientMap.put("VETP", new Ingredient("VETP", "Tomate perita", Type.VEGETAL));
        ingredientMap.put("VETC", new Ingredient("VETC", "Tomate cherry", Type.VEGETAL));
        ingredientMap.put("VERU", new Ingredient("VERU", "Rúcula", Type.VEGETAL));
        ingredientMap.put("VEES", new Ingredient("VEES", "Espinaca", Type.VEGETAL));
        ingredientMap.put("VEBE", new Ingredient("VEBE", "Berenjena", Type.VEGETAL));
        ingredientMap.put("VEZU", new Ingredient("VEZU", "Zucchini", Type.VEGETAL));
        ingredientMap.put("VECH", new Ingredient("VECH", "Choclo", Type.VEGETAL));
        ingredientMap.put("FRAN", new Ingredient("FRAN", "Ananá", Type.FRUTA));
        ingredientMap.put("FRMA", new Ingredient("FRMA", "Manzana", Type.FRUTA));
        ingredientMap.put("EXOR", new Ingredient("EXOR", "Orégano", Type.EXTRA));
        ingredientMap.put("EXAJ", new Ingredient("EXAJ", "Ají molido", Type.EXTRA));
        ingredientMap.put("EXAO", new Ingredient("EXAO", "Aceite de oliva", Type.EXTRA));
        ingredientMap.put("EXMI", new Ingredient("EXMI", "Miel", Type.EXTRA));
        ingredientMap.put("EXNU", new Ingredient("EXNU", "Nueces", Type.EXTRA));
}

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
