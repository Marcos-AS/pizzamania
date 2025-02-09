package com.example.pizzamania;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final StringToIngredientUDTConverter stringToIngredientUDTConverter;

    public WebConfig(StringToIngredientUDTConverter stringToIngredientUDTConverter) {
        this.stringToIngredientUDTConverter = stringToIngredientUDTConverter;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToIngredientUDTConverter);
    }
}
