package com.example.pizzamania;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import lombok.Data;

@Data
@Table("orders")
public class PizzaOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @PrimaryKey
    private UUID id = Uuids.timeBased();

    //@Column(name="placed_at")
    private Date placedAt;
    
    @NotBlank(message="Se requiere un nombre")
    private String deliveryName;

    @NotBlank(message="Se requiere una calle")
    private String deliveryStreet;

    @NotBlank(message="Se requiere una ciudad")
    private String deliveryCity;

    @NotBlank(message="Se requiere una provincia")
    private String deliveryProvince;

    //@Column(name="delivery_CP")
    @NotBlank(message="Se requiere un código postal")
    private String deliveryCP;

    @CreditCardNumber(message="No es un número de tarjeta de crédito válido")
    private String ccNumber; 

    @Pattern(regexp="^(0[1-9]|1[0-2])/([2-9][0-9])$", message="Debe tener formato MM/AA")
    private String ccExpiration;
    
    //@Column(name="cc_cvv")
    @Digits(integer=3, fraction=0, message="CVV inválido")
    private String ccCVV;


    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "pizzaOrder")
    @Column("pizzas")
    private List<PizzaUDT> pizzas = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizzas.add(toPizzaUDT(pizza));
    }
        
    private PizzaUDT toPizzaUDT(Pizza pizza) {
        return new PizzaUDT(pizza.getName(),pizza.getIngredients());
    }
}
