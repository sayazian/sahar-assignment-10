package com.coderscampus.recipes.domain;

public class Recipe {
    private Integer cookingMinutes;
    private Boolean dairyFree;
    private Boolean glutenFree;
    private String Instructions;
    private Double preparationMinutes;
    private Double pricePerServing;
    private Integer readyInMinutes;
    private Integer servings;
    private Double spoonacularScore;
    private String title;
    private Boolean vegan;
    private Boolean vegetarian;

    public Recipe(Integer cookingMinutes,
                  Boolean dairyFree,
                  Boolean glutenFree,
                  String Instructions,
                  Double preparationMinutes,
                  Double pricePerServing,
                  Integer readyInMinutes,
                  Integer servings,
                  Double spoonacularScore,
                  String title,
                  Boolean vegan,
                  Boolean vegetarian) {
        this.cookingMinutes = cookingMinutes;
        this.dairyFree = dairyFree;
        this.glutenFree = glutenFree;
        this.Instructions = Instructions;
        this.preparationMinutes = preparationMinutes;
        this.pricePerServing = pricePerServing;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.spoonacularScore = spoonacularScore;
        this.title = title;
        this.vegan = vegan;
        this.vegetarian = vegetarian;
    }

    public Integer getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public Boolean getDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(Boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public Double getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(Double preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public Double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getSpoonacularScore() {
        return spoonacularScore;
    }

    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String printForHTML() {
        return "<tr><td>" + title +
                "</td><td>" + cookingMinutes +
                "</td><td>" + dairyFree +
                "</td><td>" + glutenFree +
                "</td><td>" + Instructions +
                "</td><td>" + preparationMinutes +
                "</td><td>" + pricePerServing +
                "</td><td>" + readyInMinutes +
                "</td><td>" + servings +
                "</td><td>" + spoonacularScore +
                "</td><td>" + vegan +
                "</td><td>" + vegetarian +
                "</td></tr>";
    }

    public Boolean isGlutenFree() {
        return glutenFree;
    }
    public Boolean isVegan() {
        return vegan;
    }
    public Boolean isVeganAndGlutenFree() {
        return vegan && glutenFree;
    }
    public Boolean isGVegetarian() {
        return vegetarian;
    }
}
