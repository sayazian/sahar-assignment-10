package com.coderscampus.spoonacular.web;

import com.coderscampus.spoonacular.dto.DayMeals;
import com.coderscampus.spoonacular.dto.Meal;
import com.coderscampus.spoonacular.dto.WeekMeals;
import com.coderscampus.spoonacular.dto.WeekResponse;
import com.coderscampus.spoonacular.service.MealPlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileController {

    private final MealPlansService mealPlansService;

    @Autowired
    public FileController(MealPlansService mealPlansService) {
        this.mealPlansService = mealPlansService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        WeekResponse weekResponse = mealPlansService.createWeeklyPlan(numCalories, diet, exclusions);
        System.out.println(weekResponse.getWeekMeals().getMonday().getMeals());
        ResponseEntity<WeekResponse> page = new ResponseEntity<>(weekResponse, HttpStatus.OK);
        return page;
    }


//    @GetMapping("mealplanner/day")
    @GetMapping("")

    public ResponseEntity<DayMeals> getDayMeals(String numCalories, String diet, String exclusions) {
        DayMeals dayMeals = mealPlansService.createDailyPlan(numCalories, diet, exclusions);
        System.out.println(dayMeals.getMeals());
        ResponseEntity<DayMeals> page = new ResponseEntity<>(dayMeals, HttpStatus.OK);
        return page;
    }
}
