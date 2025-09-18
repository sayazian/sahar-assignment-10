package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class WeekResponse {

    @JsonProperty("week")
    private Map<String, DayResponse> weekMeals;

    public Map<String, DayResponse> getWeekMeals() {
        return weekMeals;
    }

    public void setWeekMeals(Map<String, DayResponse> weekMeals) {
        this.weekMeals = weekMeals;
    }
}