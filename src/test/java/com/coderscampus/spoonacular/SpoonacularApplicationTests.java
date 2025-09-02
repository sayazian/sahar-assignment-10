package com.coderscampus.spoonacular;

import com.coderscampus.spoonacular.dto.Meal;
import com.coderscampus.spoonacular.dto.RecipeResponse;
import com.coderscampus.spoonacular.dto.SpoonacularResponse;
import com.coderscampus.spoonacular.dto.WeekMeals;
import com.coderscampus.spoonacular.dto.WeekResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpoonacularApplicationTests {

	@Test
	void callApi() {
		RestTemplate restTemplate = new RestTemplate();
		String myApiKey = "7a7f9f134e69494583c524db8e2068e5";

		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/complexSearch?&apiKey=" + myApiKey)
				.queryParam("timeFrame", "day" )
				.queryParam("targetCalories", 2000)
				.queryParam("diet", "vegetarian")
				.queryParam("exclude", "shellfish, olives")
				.build()
				.toUri();

		ResponseEntity<SpoonacularResponse> response = restTemplate.getForEntity(uri, SpoonacularResponse.class);
		Stream<RecipeResponse> resultsStream = Arrays.stream(Objects.requireNonNull(response.getBody()).getResults());
		System.out.println(resultsStream.map(RecipeResponse::printResponse).collect(Collectors.joining("\n")));
	}

	@Test
	void getWeeklyPlan() {
		//https://api.spoonacular.com/mealplanner/ac172361-12e4-4dc7-a21e-814756eeda0c/week/2025-09-01?hash=902449678fceda3041b4ae7ea3e985cab0244b17
		RestTemplate restTemplate = new RestTemplate();
		String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
		String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
		String myUsername = "ac172361-12e4-4dc7-a21e-814756eeda0c";
		String myDate = "2025-09-01";
//		https://api.spoonacular.com/mealplanner/ac172361-12e4-4dc7-a21e-814756eeda0c/week/2025-09-01?hash=902449678fceda3041b4ae7ea3e985cab0244b17&apiKey=7a7f9f134e69494583c524db8e2068e5
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/" + myUsername + "/week/"
				+ myDate + "?hash=" + myHash
				+ "&apiKey=" + myApiKey)
				.queryParam("timeFrame", "day" )
				.queryParam("targetCalories", 2000)
				.queryParam("diet", "vegetarian")
				.queryParam("exclude", "shellfish, olives")
				.build()
				.toUri();

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		System.out.println(response);
//		ResponseEntity<SpoonacularResponse> response = restTemplate.getForEntity(uri, SpoonacularResponse.class);
//		Stream<RecipeResponse> resultsStream = Arrays.stream(Objects.requireNonNull(response.getBody()).getResults());
//		System.out.println(resultsStream.map(RecipeResponse::printResponse).collect(Collectors.joining("\n")));
	}

	@Test
	void testWeekPlanDeserializing() {

		String input = """
				{
				    "week": {
				        "monday": {
				            "meals": [
				                {
				                    "id": 716276,
				                    "image": "doughnuts-716276.jpg",
				                    "imageType": "jpg",
				                    "title": "Doughnuts",
				                    "readyInMinutes": 45,
				                    "servings": 2,
				                    "sourceUrl": "https://www.afrolems.com/2014/03/25/doughnuts-recipe/"
				                },
				                {
				                    "id": 643674,
				                    "image": "Fried-Brown-Rice-643674.jpg",
				                    "imageType": "jpg",
				                    "title": "Fried Brown Rice",
				                    "readyInMinutes": 25,
				                    "servings": 2,
				                    "sourceUrl": "https://www.foodista.com/recipe/SFXY6WMQ/fried-brown-rice"
				                },
				                {
				                    "id": 649718,
				                    "image": "Lemon-Pasta-Alfredo-(Vegan)-649718.jpg",
				                    "imageType": "jpg",
				                    "title": "Lemon Pasta Alfredo (Vegan)",
				                    "readyInMinutes": 45,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/N8TVP5V4/lemon-pasta-alfredo-vegan"
				                }
				            ],
				            "nutrients": {
				                "calories": 1842.36,
				                "protein": 51.46,
				                "fat": 67.64,
				                "carbohydrates": 261.08
				            }
				        },
				        "tuesday": {
				            "meals": [
				                {
				                    "id": 716276,
				                    "image": "doughnuts-716276.jpg",
				                    "imageType": "jpg",
				                    "title": "Doughnuts",
				                    "readyInMinutes": 45,
				                    "servings": 2,
				                    "sourceUrl": "https://www.afrolems.com/2014/03/25/doughnuts-recipe/"
				                },
				                {
				                    "id": 643674,
				                    "image": "Fried-Brown-Rice-643674.jpg",
				                    "imageType": "jpg",
				                    "title": "Fried Brown Rice",
				                    "readyInMinutes": 25,
				                    "servings": 2,
				                    "sourceUrl": "https://www.foodista.com/recipe/SFXY6WMQ/fried-brown-rice"
				                },
				                {
				                    "id": 640338,
				                    "image": "Cracked-Wheat-Salad-with-Dates---Tahini-Yogurt-640338.jpg",
				                    "imageType": "jpg",
				                    "title": "Cracked Wheat Salad with Dates & Tahini Yogurt",
				                    "readyInMinutes": 45,
				                    "servings": 2,
				                    "sourceUrl": "https://www.foodista.com/recipe/6PVSJLCP/cracked-wheat-salad-with-dates-tahini-yogrt"
				                }
				            ],
				            "nutrients": {
				                "calories": 1790.74,
				                "protein": 61.59,
				                "fat": 63.53,
				                "carbohydrates": 264.2
				            }
				        },
				        "wednesday": {
				            "meals": [
				                {
				                    "id": 640767,
				                    "image": "Crepes-Suzette-640767.jpg",
				                    "imageType": "jpg",
				                    "title": "Crepes Suzette",
				                    "readyInMinutes": 45,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/KD8ZMRJ6/crepes-suzette"
				                },
				                {
				                    "id": 653251,
				                    "image": "Noodles-and-Veggies-With-Peanut-Sauce-653251.jpg",
				                    "imageType": "jpg",
				                    "title": "Noodles and Veggies With Peanut Sauce",
				                    "readyInMinutes": 30,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/5VRHVVWQ/noodles-and-veggies-with-peanut-sauce"
				                },
				                {
				                    "id": 654935,
				                    "image": "Pasta-with-Peas-and-Italian-Sausage-654935.jpg",
				                    "imageType": "jpg",
				                    "title": "Pasta with Peas and Italian Sausage",
				                    "readyInMinutes": 45,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/6TFQVSP7/pasta-with-peas-and-italian-sausage"
				                }
				            ],
				            "nutrients": {
				                "calories": 1880.73,
				                "protein": 51.52,
				                "fat": 76.46,
				                "carbohydrates": 250.17
				            }
				        },
				        "thursday": {
				            "meals": [
				                {
				                    "id": 644854,
				                    "image": "Gluten-Free-Quinoa-and-Corn-Flour-Crepes-644854.jpg",
				                    "imageType": "jpg",
				                    "title": "Gluten Free Quinoa and Corn Flour Crepes",
				                    "readyInMinutes": 60,
				                    "servings": 4,
				                    "sourceUrl": "http://www.foodista.com/recipe/MGMB6CBY/gluten-free-quinoa-and-corn-flour-crepes"
				                },
				                {
				                    "id": 1697541,
				                    "image": "pasta-with-feta-cheese-and-asparagus-1697541.jpg",
				                    "imageType": "jpg",
				                    "title": "Pasta With Feta Cheese And Asparagus",
				                    "readyInMinutes": 20,
				                    "servings": 2,
				                    "sourceUrl": "https://maplewoodroad.com/pasta-with-feta-cheese-and-asparagus/"
				                },
				                {
				                    "id": 1005368,
				                    "image": "panzanella-salad-1005368.jpg",
				                    "imageType": "jpg",
				                    "title": "Panzanella Salad",
				                    "readyInMinutes": 45,
				                    "servings": 4,
				                    "sourceUrl": "https://pickfreshfoods.com/panzanella-salad/"
				                }
				            ],
				            "nutrients": {
				                "calories": 1886.15,
				                "protein": 57.59,
				                "fat": 71.48,
				                "carbohydrates": 258.46
				            }
				        },
				        "friday": {
				            "meals": [
				                {
				                    "id": 632639,
				                    "image": "Applesauce-Carrot-Cake-Muffins-632639.jpg",
				                    "imageType": "jpg",
				                    "title": "Applesauce Carrot Cake Muffins",
				                    "readyInMinutes": 45,
				                    "servings": 24,
				                    "sourceUrl": "https://www.foodista.com/recipe/CTFGJLFC/applesauce-carrot-cake-muffins"
				                },
				                {
				                    "id": 642585,
				                    "image": "Farfalle-with-fresh-tomatoes--basil-and-mozzarella-642585.jpg",
				                    "imageType": "jpg",
				                    "title": "Farfalle with fresh tomatoes, basil and mozzarella",
				                    "readyInMinutes": 15,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/B6CC3QXM/farfalle-with-fresh-tomatoes-basil-and-mozzarella"
				                },
				                {
				                    "id": 660366,
				                    "image": "Smoked-Salmon-and-Mascarpone-Calzone-660366.jpg",
				                    "imageType": "jpg",
				                    "title": "Smoked Salmon and Mascarpone Calzone",
				                    "readyInMinutes": 45,
				                    "servings": 2,
				                    "sourceUrl": "https://www.foodista.com/recipe/PB3V8BYG/smoked-salmon-and-mascarpone-calzone"
				                }
				            ],
				            "nutrients": {
				                "calories": 1768.59,
				                "protein": 52.86,
				                "fat": 65.81,
				                "carbohydrates": 244.16
				            }
				        },
				        "saturday": {
				            "meals": [
				                {
				                    "id": 716276,
				                    "image": "doughnuts-716276.jpg",
				                    "imageType": "jpg",
				                    "title": "Doughnuts",
				                    "readyInMinutes": 45,
				                    "servings": 2,
				                    "sourceUrl": "https://www.afrolems.com/2014/03/25/doughnuts-recipe/"
				                },
				                {
				                    "id": 653251,
				                    "image": "Noodles-and-Veggies-With-Peanut-Sauce-653251.jpg",
				                    "imageType": "jpg",
				                    "title": "Noodles and Veggies With Peanut Sauce",
				                    "readyInMinutes": 30,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/5VRHVVWQ/noodles-and-veggies-with-peanut-sauce"
				                },
				                {
				                    "id": 715595,
				                    "image": "cheesiest-bowtie-mac-and-cheese-715595.jpg",
				                    "imageType": "jpg",
				                    "title": "How to Make the Cheesiest Bowtie Mac and Cheese",
				                    "readyInMinutes": 35,
				                    "servings": 4,
				                    "sourceUrl": "https://www.pinkwhen.com/mac-and-cheese-recipe/"
				                }
				            ],
				            "nutrients": {
				                "calories": 1895.95,
				                "protein": 60.76,
				                "fat": 61.9,
				                "carbohydrates": 273.96
				            }
				        },
				        "sunday": {
				            "meals": [
				                {
				                    "id": 648006,
				                    "image": "Irish-Soda-Bread-By-Mommie-Cooks-648006.jpg",
				                    "imageType": "jpg",
				                    "title": "Irish Soda Bread By Mommie Cooks",
				                    "readyInMinutes": 45,
				                    "servings": 8,
				                    "sourceUrl": "https://www.foodista.com/recipe/RNKM52BK/irish-soda-bread-by-mommie-cooks"
				                },
				                {
				                    "id": 642585,
				                    "image": "Farfalle-with-fresh-tomatoes--basil-and-mozzarella-642585.jpg",
				                    "imageType": "jpg",
				                    "title": "Farfalle with fresh tomatoes, basil and mozzarella",
				                    "readyInMinutes": 15,
				                    "servings": 4,
				                    "sourceUrl": "https://www.foodista.com/recipe/B6CC3QXM/farfalle-with-fresh-tomatoes-basil-and-mozzarella"
				                },
				                {
				                    "id": 1697541,
				                    "image": "pasta-with-feta-cheese-and-asparagus-1697541.jpg",
				                    "imageType": "jpg",
				                    "title": "Pasta With Feta Cheese And Asparagus",
				                    "readyInMinutes": 20,
				                    "servings": 2,
				                    "sourceUrl": "https://maplewoodroad.com/pasta-with-feta-cheese-and-asparagus/"
				                }
				            ],
				            "nutrients": {
				                "calories": 1743.59,
				                "protein": 55.99,
				                "fat": 57.54,
				                "carbohydrates": 250.4
				            }
				        }
				    }
				}""";
		ObjectMapper mapper = new ObjectMapper();
		try {
			WeekResponse weekResponse = mapper.readValue(input, WeekResponse.class);

			System.out.println(mapper.writeValueAsString(weekResponse));


		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testWeekPlanDeserializingWeb() {

		RestTemplate restTemplate = new RestTemplate();
		String myApiKey = "7a7f9f134e69494583c524db8e2068e5";
		String myHash = "902449678fceda3041b4ae7ea3e985cab0244b17";
		String myUsername = "ac172361-12e4-4dc7-a21e-814756eeda0c";
//		String input = "https://api.spoonacular.com/mealplanner/generate?timeFrame=week&hash=902449678fceda3041b4ae7ea3e985cab0244b17&apiKey=7a7f9f134e69494583c524db8e2068e5";
		String input = "https://api.spoonacular.com/mealplanner/generate?";
		URI uri = UriComponentsBuilder.fromHttpUrl(input)
				.queryParam("timeFrame", "week")
				.queryParam("hash", myHash)
				.queryParam("apiKey", myApiKey)
//				.queryParam("timeFrame", "day" )
//				.queryParam("targetCalories", 2000)
//				.queryParam("diet", "vegetarian")
//				.queryParam("exclude", "shellfish, olives")
				.build()
				.toUri();

		ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
//		Stream<RecipeResponse> resultsStream = Arrays.stream(Objects.requireNonNull(response.getBody()).getResults());
//		System.out.println(resultsStream.map(RecipeResponse::printResponse).collect(Collectors.joining("\n")));
		WeekMeals weekMeals = Objects.requireNonNull(response.getBody()).getWeekMeals();
		System.out.println(Arrays.stream(weekMeals.getMonday().getMeals()).map(Meal::getTitle).collect(Collectors.joining("\n")));
	}

}
