package com.coderscampus.spoonacular.service;

import com.coderscampus.spoonacular.dto.DayMeals;
import com.coderscampus.spoonacular.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class MealPlansService {

    public WeekResponse createWeeklyPlan(String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
        String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
        String input = "https://api.spoonacular.com/mealplanner/generate?";
        URI uri;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(input)
                .queryParam("timeFrame", "week")
                .queryParam("hash", myHash)
                .queryParam("apiKey", myApiKey);
        if (numCalories != null) {
            uriComponentsBuilder.queryParam("targetCalories", numCalories);
        }
        if (diet != null) {
            uriComponentsBuilder.queryParam("diet", diet);
        }
        if (exclusions != null) {
            uriComponentsBuilder.queryParam("exclude", exclusions);
        }

        uri = uriComponentsBuilder
                .build()
                .toUri();
        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
        return response.getBody();
    }

    public DayMeals createDailyPlan(String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
        String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
        String input = "https://api.spoonacular.com/mealplanner/generate?";
        URI uri;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(input)
                .queryParam("timeFrame", "day")
                .queryParam("hash", myHash)
                .queryParam("apiKey", myApiKey);
        if (numCalories != null) {
            uriComponentsBuilder.queryParam("targetCalories", numCalories);
        }
        if (diet != null) {
            uriComponentsBuilder.queryParam("diet", diet);
        }
        if (exclusions != null) {
            uriComponentsBuilder.queryParam("exclude", exclusions);
        }

        uri = uriComponentsBuilder
                .build()
                .toUri();

        ResponseEntity<DayMeals> response = restTemplate.getForEntity(uri, DayMeals.class);
        return response.getBody();
    }
}
