package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayMeals {

    @JsonProperty("meals")
    private Meal[] meals;

    @JsonProperty("nutrients")
    private NutrientsResponse nutrients;

    public Meal[] getMeals() {
        return meals;
    }

    public void setMeals(Meal[] meals) {
        this.meals = meals;
    }

    public NutrientsResponse getNutrients() {
        return nutrients;
    }

    public void setNutrients(NutrientsResponse nutrients) {
        this.nutrients = nutrients;
    }
}
