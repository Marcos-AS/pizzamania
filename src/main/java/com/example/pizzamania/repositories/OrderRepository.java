package com.example.pizzamania.repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pizzamania.entities.PizzaOrder;

@Repository
public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
    PizzaOrder save(PizzaOrder order);
    List<PizzaOrder> findByDeliveryCP(String deliveryCP);
    List<PizzaOrder> readOrdersByDeliveryCPAndPlacedAtBetween(String deliveryCP, Date startDate, Date endDate);
}
