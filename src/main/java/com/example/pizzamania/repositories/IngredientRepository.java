package com.example.pizzamania.repositories;

//import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pizzamania.entities.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    //Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
