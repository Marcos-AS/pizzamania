package com.example.pizzamania;

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
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder order, Errors errors,
                                SessionStatus sessionStatus) {
        //el objeto PizzaOrder que se mantiene con SessionAttributes
        //al llamar a setComplete, se limpia la sesión y queda lista para una nueva orden
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("orden enviada: {}", order);        
        sessionStatus.setComplete();
        return "redirect:/";
    }
    
}
