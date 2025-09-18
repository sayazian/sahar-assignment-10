package com.coderscampus.spoonacular.service;

import com.coderscampus.spoonacular.dto.DayResponse;
import com.coderscampus.spoonacular.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class MealPlansService {

    RestTemplate restTemplate = new RestTemplate();
    @Value("${spoonacular.api.key}")
    String spoonacularApiKey;

    @Value("${spoonacular.hash}")
    String spoonacularHash;

    @Value("${spoonacular.url}")
    String spoonacularUrl;


    public ResponseEntity<WeekResponse> createWeeklyPlan(String numCalories, String diet, String exclusions) {
        URI uri = getUri("week", numCalories, diet, exclusions);
        return ResponseEntity.ok(restTemplate.getForEntity(uri, WeekResponse.class).getBody());
    }


    public ResponseEntity<DayResponse> createDailyPlan(String numCalories, String diet, String exclusions) {
        URI uri = getUri("day", numCalories, diet, exclusions);
        return ResponseEntity.ok(restTemplate.getForEntity(uri, DayResponse.class).getBody());
    }


    private URI getUri(String period, String numCalories, String diet, String exclusions) {
        return UriComponentsBuilder.fromUriString(spoonacularUrl)
                .queryParam("timeFrame", period)
                .queryParam("hash", spoonacularHash)
                .queryParam("apiKey", spoonacularApiKey)
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("diet", Optional.ofNullable(diet))
                .queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
                .build()
                .toUri();
    }

}
