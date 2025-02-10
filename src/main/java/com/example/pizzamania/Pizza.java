package com.example.pizzamania;

import java.util.Date;
import java.util.List;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message="El nombre debe tener al menos 5 caracteres")
    private String name;

    private Date createdAt = new Date();
    
    @Size(min=1, message="Debes elegir al menos 1 ingrediente")
    @ManyToMany
    private List<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "pizza_order", nullable = false)
    private PizzaOrder pizzaOrder;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
