package com.coderscampus.spoonacular.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpoonacularResponse {
    @JsonProperty("results")
    private RecipeResponse[] results;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("number")
    private long number;

    @JsonProperty("totalResults")
    private long totalResults;

    public RecipeResponse[] getResults() {
        return results;
    }

    public void setResults(RecipeResponse[] results) {
        this.results = results;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

}
