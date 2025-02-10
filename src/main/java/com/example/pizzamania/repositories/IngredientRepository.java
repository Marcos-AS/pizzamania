package com.example.pizzamania.repositories;

//import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.example.pizzamania.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    //Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
