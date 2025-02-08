package com.example.pizzamania;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {
    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder order, Errors errors,
                                SessionStatus sessionStatus) {
        //el objeto PizzaOrder que se mantiene con SessionAttributes
        //al llamar a setComplete, se limpia la sesión y queda lista para una nueva orden
        //System.out.println("ORDER: " + order);
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setPlacedAt(new Date());
        orderRepo.save(order);
        //log.info("orden enviada: {}", order);        
        sessionStatus.setComplete();
        return "redirect:/";
    }
    
}
