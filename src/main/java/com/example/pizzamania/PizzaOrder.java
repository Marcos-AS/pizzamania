package com.example.pizzamania;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;

@Data
public class PizzaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;

    private Date placedAt;

    @NotBlank(message="Se requiere un nombre")
    private String deliveryName;

    @NotBlank(message="Se requiere una calle")
    private String deliveryStreet;

    @NotBlank(message="Se requiere una ciudad")
    private String deliveryCity;

    @NotBlank(message="Se requiere una provincia")
    private String deliveryProvince;

    @NotBlank(message="Se requiere un código postal")
    private String deliveryCP;

    @CreditCardNumber(message="No es un número de tarjeta de crédito válido")
    private String ccNumber; 

    @Pattern(regexp="^(0[1-9]|1[0-2]) ([\\/]) ([2-9][0-9])$", message="Debe tener formato MM/AA")
    private String ccExpiration;
    
    @Digits(integer=3, fraction=0, message="CVV inválido")
    private String ccCVV;

    private List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}
