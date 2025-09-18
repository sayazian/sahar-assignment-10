package com.coderscampus.spoonacular.web;

import com.coderscampus.spoonacular.dto.DayResponse;
import com.coderscampus.spoonacular.dto.WeekResponse;
import com.coderscampus.spoonacular.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MealPlansController {

    private final MealPlansService mealPlansService;

    public MealPlansController(MealPlansService mealPlansService) {
        this.mealPlansService = mealPlansService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        return mealPlansService.createWeeklyPlan(numCalories, diet, exclusions);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return mealPlansService.createDailyPlan(numCalories, diet, exclusions);
    }
}
