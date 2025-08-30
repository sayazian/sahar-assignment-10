package com.coderscampus.recipes.service;

import com.coderscampus.recipes.domain.Recipe;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public final List<Recipe> RECIPES = this.parseRecipes("recipes.txt");
    public List<Recipe> parseRecipes(String csvFilePath) {

        List<Recipe> recipes = new ArrayList<>();

        try (Reader in = new FileReader(csvFilePath)) {
            // Define the CSV format: EXCEL format with header detection
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes", "Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan", "Vegetarian") // Auto-detect header from the first line
                    .setSkipHeaderRecord(true).setIgnoreSurroundingSpaces(true).setEscape('\\').get();

            // Create a CSVParser
            CSVParser parser = csvFormat.parse(in);
            // Iterate over the records
            for (CSVRecord record : parser) {
                int cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
                boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
                boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
                String instructions = record.get("Instructions");
                double preparationMinutes = Double.parseDouble(record.get("Preparation Minutes"));
                double pricePerServing = Double.parseDouble(record.get("Price Per Serving"));
                int readyInMinutes = Integer.parseInt(record.get("Ready In Minutes"));
                int servings = Integer.parseInt(record.get("Servings"));
                Double spoonacularScore = Double.parseDouble(record.get("Spoonacular Score"));
                String title = record.get("Title");
                boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
                boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
                recipes.add(new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian));
            }

        } catch (IOException e) {
            System.out.println("Oops! A problem occurred reading the file." + e.getMessage());
        }
        return recipes;
    }

}
