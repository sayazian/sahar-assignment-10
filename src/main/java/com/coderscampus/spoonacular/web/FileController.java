package com.coderscampus.spoonacular.web;

import com.coderscampus.spoonacular.dto.DayMeals;
import com.coderscampus.spoonacular.dto.WeekResponse;
import com.coderscampus.spoonacular.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileController {

    private final MealPlansService mealPlansService;

    @Autowired
    public FileController(MealPlansService mealPlansService) {
        this.mealPlansService = mealPlansService;
    }

//    @GetMapping("")
    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        WeekResponse weekResponse = mealPlansService.createWeeklyPlan(numCalories, diet, exclusions);
        return new ResponseEntity<>(weekResponse, HttpStatus.OK);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayMeals> getDayMeals(String numCalories, String diet, String exclusions) {
        DayMeals dayMeals = mealPlansService.createDailyPlan(numCalories, diet, exclusions);
        return new ResponseEntity<>(dayMeals, HttpStatus.OK);
    }
}
