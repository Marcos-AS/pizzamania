package com.example.pizzamania;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<PizzaOrder, UUID> {
    PizzaOrder save(PizzaOrder order);
    List<PizzaOrder> findByDeliveryCP(String deliveryCP);
    List<PizzaOrder> readOrdersByDeliveryCPAndPlacedAtBetween(String deliveryCP, Date startDate, Date endDate);
}
