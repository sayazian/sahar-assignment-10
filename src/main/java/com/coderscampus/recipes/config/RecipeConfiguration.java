package com.coderscampus.recipes.config;

import com.coderscampus.recipes.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfiguration {

    @Bean
    public FileService fileService() {
        return new FileService();
    }

}
