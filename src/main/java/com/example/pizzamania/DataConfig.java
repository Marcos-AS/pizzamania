package com.example.pizzamania;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.pizzamania.Ingredient.Type;

//@Configuration
public class DataConfig {
    // @Bean
    // public ApplicationRunner dataLoader(IngredientRepository repo) {
    //     return args -> {
    //         repo.save(new Ingredient("QUMO", "Queso Mozzarella", Type.QUESO));
    //         repo.save(new Ingredient("QUPR", "Queso Provolone", Type.QUESO));
    //         repo.save(new Ingredient("QUPA", "Queso Parmesano", Type.QUESO));
    //         repo.save(new Ingredient("QURO", "Queso Roquefort", Type.QUESO));
    //         repo.save(new Ingredient("QUCA", "Queso de cabra", Type.QUESO));
    //         repo.save(new Ingredient("PRPO", "Pollo", Type.PROTEINA));
    //         repo.save(new Ingredient("PRPA", "Panceta", Type.PROTEINA));
    //         repo.save(new Ingredient("PRAN", "Anchoas", Type.PROTEINA));
    //         repo.save(new Ingredient("PRCP", "Carne picada", Type.PROTEINA));
    //         repo.save(new Ingredient("PRHU", "Huevo", Type.PROTEINA));
    //         repo.save(new Ingredient("VECE", "Cebolla", Type.VEGETAL));
    //         repo.save(new Ingredient("VETP", "Tomate perita", Type.VEGETAL));
    //         repo.save(new Ingredient("VETC", "Tomate cherry", Type.VEGETAL));
    //         repo.save(new Ingredient("VERU", "Rúcula", Type.VEGETAL));
    //         repo.save(new Ingredient("VEES", "Espinaca", Type.VEGETAL));
    //         repo.save(new Ingredient("VEBE", "Berenjena", Type.VEGETAL));
    //         repo.save(new Ingredient("VEZU", "Zucchini", Type.VEGETAL));
    //         repo.save(new Ingredient("VECH", "Choclo", Type.VEGETAL));
    //         repo.save(new Ingredient("FRAN", "Ananá", Type.FRUTA));
    //         repo.save(new Ingredient("FRMA", "Manzana", Type.FRUTA));
    //         repo.save(new Ingredient("EXOR", "Orégano", Type.EXTRA));
    //         repo.save(new Ingredient("EXAJ", "Ají molido", Type.EXTRA));
    //         repo.save(new Ingredient("EXAO", "Aceite de oliva", Type.EXTRA));
    //         repo.save(new Ingredient("EXMI", "Miel", Type.EXTRA));
    //         repo.save(new Ingredient("EXNU", "Nueces", Type.EXTRA));
    //     };
    // }
}