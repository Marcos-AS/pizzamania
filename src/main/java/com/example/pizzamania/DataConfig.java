package com.example.pizzamania;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.pizzamania.Ingredient.Type;

@Configuration
public class DataConfig {

    @Bean
    public ApplicationRunner dataLoader(IngredientRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                new Ingredient("QUMO", "Queso Mozzarella", Type.QUESO),
                new Ingredient("QUPR", "Queso Provolone", Type.QUESO),
                new Ingredient("QUPA", "Queso Parmesano", Type.QUESO),
                new Ingredient("QURO", "Queso Roquefort", Type.QUESO),
                new Ingredient("QUCA", "Queso de cabra", Type.QUESO),
                new Ingredient("PRPO", "Pollo", Type.PROTEINA),
                new Ingredient("PRPA", "Panceta", Type.PROTEINA),
                new Ingredient("PRAN", "Anchoas", Type.PROTEINA),
                new Ingredient("PRCP", "Carne picada", Type.PROTEINA),
                new Ingredient("PRHU", "Huevo", Type.PROTEINA),
                new Ingredient("VECE", "Cebolla", Type.VEGETAL),
                new Ingredient("VETP", "Tomate perita", Type.VEGETAL),
                new Ingredient("VETC", "Tomate cherry", Type.VEGETAL),
                new Ingredient("VERU", "Rúcula", Type.VEGETAL),
                new Ingredient("VEES", "Espinaca", Type.VEGETAL),
                new Ingredient("VEBE", "Berenjena", Type.VEGETAL),
                new Ingredient("VEZU", "Zucchini", Type.VEGETAL),
                new Ingredient("VECH", "Choclo", Type.VEGETAL),
                new Ingredient("FRAN", "Ananá", Type.FRUTA),
                new Ingredient("FRMA", "Manzana", Type.FRUTA),
                new Ingredient("EXOR", "Orégano", Type.EXTRA),
                new Ingredient("EXAJ", "Ají molido", Type.EXTRA),
                new Ingredient("EXAO", "Aceite de oliva", Type.EXTRA),
                new Ingredient("EXMI", "Miel", Type.EXTRA),
                new Ingredient("EXNU", "Nueces", Type.EXTRA)
            ));
        };
    }
}