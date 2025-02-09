package com.example.pizzamania;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
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
@AllArgsConstructor
//@RequiredArgsConstructor
//no debe poder accederse, por eso PRIVATE y para setear props con final se usa force = true
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table("ingredients")
public class Ingredient {

    @PrimaryKey
    private String id;

    private String name;

    //@Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        PROTEINA, VEGETAL, QUESO, FRUTA, EXTRA
    }
}