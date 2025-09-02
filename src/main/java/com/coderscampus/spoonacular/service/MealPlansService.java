package com.coderscampus.spoonacular.service;

import com.coderscampus.spoonacular.dto.DayMeals;
import com.coderscampus.spoonacular.dto.Meal;
import com.coderscampus.spoonacular.dto.WeekMeals;
import com.coderscampus.spoonacular.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class MealPlansService {

    public WeekResponse createWeeklyPlan (String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
        String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
        String myUsername = "ac172361-12e4-4dc7-a21e-814756eeda0c";
        String input = "https://api.spoonacular.com/mealplanner/generate?";
        URI uri = UriComponentsBuilder.fromHttpUrl(input)
                .queryParam("timeFrame", "week")
                .queryParam("hash", myHash)
                .queryParam("apiKey", myApiKey)
				.queryParam("targetCalories", numCalories)
				.queryParam("diet", diet)
				.queryParam("exclude", exclusions)
                .build()
                .toUri();

        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
        return response.getBody();
    }

    public DayMeals createDailyPlan (String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
        String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
        String myUsername = "ac172361-12e4-4dc7-a21e-814756eeda0c";
        String input = "https://api.spoonacular.com/mealplanner/generate?";
        URI uri = UriComponentsBuilder.fromHttpUrl(input)
                .queryParam("timeFrame", "day")
                .queryParam("hash", myHash)
                .queryParam("apiKey", myApiKey)
                .queryParam("targetCalories", numCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .build()
                .toUri();

        ResponseEntity<DayMeals> response = restTemplate.getForEntity(uri, DayMeals.class);
        return response.getBody();
    }
}
