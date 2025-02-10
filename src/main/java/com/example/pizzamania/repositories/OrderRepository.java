package com.example.pizzamania.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.pizzamania.PizzaOrder;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
    PizzaOrder save(PizzaOrder order);
    List<PizzaOrder> findByDeliveryCP(String deliveryCP);
    List<PizzaOrder> readOrdersByDeliveryCPAndPlacedAtBetween(String deliveryCP, Date startDate, Date endDate);
}
