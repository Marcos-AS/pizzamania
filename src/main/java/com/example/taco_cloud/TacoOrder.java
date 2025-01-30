package com.example.taco_cloud;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TacoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryProvince;
    private String deliveryCP;
    private String ccNumber; //credit card
    private String ccExpiration;
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
