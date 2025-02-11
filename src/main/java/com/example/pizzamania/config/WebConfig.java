package com.example.pizzamania.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.example.pizzamania.converters.StringToIngredientUDTConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final StringToIngredientUDTConverter stringToIngredientUDTConverter;

    public WebConfig(StringToIngredientUDTConverter stringToIngredientUDTConverter) {
        this.stringToIngredientUDTConverter = stringToIngredientUDTConverter;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToIngredientUDTConverter);
    }
}