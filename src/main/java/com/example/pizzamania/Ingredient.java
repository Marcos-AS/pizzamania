package com.example.pizzamania;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
import lombok.AccessLevel;

@Data
@Document
@AllArgsConstructor
//@RequiredArgsConstructor
//no debe poder accederse, por eso PRIVATE y para setear props con final se usa force = true
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private String id;

    private String name;

    //@Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        PROTEINA, VEGETAL, QUESO, FRUTA, EXTRA
    }
}