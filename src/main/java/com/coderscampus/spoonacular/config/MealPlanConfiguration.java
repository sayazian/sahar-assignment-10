package com.coderscampus.spoonacular.config;

import com.coderscampus.spoonacular.service.MealPlansService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealPlanConfiguration {

    @Bean
    public MealPlansService mealPlansService() { return new MealPlansService();}

}
