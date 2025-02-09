package com.example.pizzamania;

import java.util.Date;
import java.util.List;

import lombok.Data;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class Pizza {

    @NotNull
    @Size(min=5, message="El nombre debe tener al menos 5 caracteres")
    private String name;

    private Date createdAt = new Date();
    
    @Size(min=1, message="Debes elegir al menos 1 ingrediente")
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
