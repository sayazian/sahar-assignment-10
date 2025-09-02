package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WeekResponse {

    @JsonProperty("week")
    private WeekMeals weekMeals;

    public WeekMeals getWeekMeals() {
        return weekMeals;
    }

    public void setWeekMeals(WeekMeals weekMeals) {
        this.weekMeals = weekMeals;
    }
}