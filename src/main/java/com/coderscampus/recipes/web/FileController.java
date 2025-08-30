package com.coderscampus.recipes.web;

import com.coderscampus.recipes.domain.Recipe;
import com.coderscampus.recipes.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;
    private final String start = "<table border = 2px>";
    private final String titles = "<tr><td>  Title " +
            "  </td><td> Cooking Minutes" +
            " </td><td>Dairy Free" +
            " </td><td>Gluten Free " +
            " </td><td>Instructions " +
            " </td><td>Preparation Minutes " +
            " </td><td>Price Per Serving" +
            " </td><td>Ready In Minutes" +
            " </td><td>Servings" +
            " </td><td>Spoonacular Score" +
            " </td><td>Vegan" +
            " </td><td>Vegetarian" +
            "</td></tr>";
    private final String end = "</table>";

    @GetMapping("")
    public String renderHome() {
        String recipesRows = fileService.RECIPES.stream().map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;
    }

    @GetMapping("/gluten-free")
    public String renderGlutenFreeRecipes() {
        String recipesRows = fileService.RECIPES.stream().filter(Recipe::isGlutenFree).map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;
    }

    @GetMapping("/vegan")
    public String renderVeganRecipes() {
        String recipesRows = fileService.RECIPES.stream().filter(Recipe::isVegan).map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;
    }

    @GetMapping("/vegan-and-gluten-free")
    public String renderVeganAndGlutenFreeRecipes() {
        String recipesRows = fileService.RECIPES.stream().filter(Recipe::isVeganAndGlutenFree).map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;
    }

    @GetMapping("/vegetarian")
    public String renderVegetarian() {
        String recipesRows = fileService.RECIPES.stream().filter(Recipe::isGVegetarian).map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;
    }

    @GetMapping("/all-recipes")
    public String renderAllRecipes() {
        String recipesRows = fileService.RECIPES.stream().map(Recipe::printForHTML).collect(Collectors.joining(""));
        return start + titles + recipesRows + end;

    }

}
