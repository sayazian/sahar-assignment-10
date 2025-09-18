package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrients {

    @JsonProperty("calories")
    private Double calories;

    @JsonProperty("protein")
    private Double protein;

    @JsonProperty("fat")
    private Double fat;

    @JsonProperty("carbohydrates")
    private Double carbohydrates;

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}

