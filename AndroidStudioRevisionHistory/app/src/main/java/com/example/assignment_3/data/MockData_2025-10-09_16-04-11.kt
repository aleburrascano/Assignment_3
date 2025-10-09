package com.example.assignment_3.data

import com.example.assignment_3.R
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.models.Recipe

object MockData {
    val recipes = listOf(
        Recipe(
            name = "Classic Chocolate Chip Cookies",
            ingredients = listOf(
                Ingredient("all-purpose flour", 2.25, "cups"),
                Ingredient("baking soda", 1.0, "tsp"),
                Ingredient("salt", 1.0, "tsp"),
                Ingredient("butter", 1.0, "cup"),
                Ingredient("granulated sugar", 0.75, "cup"),
                Ingredient("brown sugar", 0.75, "cup"),
                Ingredient("large eggs", 2.0, ""),
                Ingredient("vanilla extract", 2.0, "tsp"),
                Ingredient("chocolate chips", 2.0, "cups")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.classic_chocolate_chip_cookies}"
        ),
        Recipe(
            name = "Creamy Chicken Alfredo",
            ingredients = listOf(
                Ingredient("fettuccine pasta", 1.0, "lb"),
                Ingredient("chicken breast", 1.0, "lb"),
                Ingredient("heavy cream", 1.0, "cup"),
                Ingredient("parmesan cheese", 1.0, "cup"),
                Ingredient("butter", 4.0, "tbsp"),
                Ingredient("garlic cloves", 3.0, ""),
                Ingredient("salt", 0.0, "to taste"),
                Ingredient("black pepper", 0.0, "to taste")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.creamy_chicken_alfredo}"
        ),
        Recipe(
            name = "Fresh Garden Salad",
            ingredients = listOf(
                Ingredient("mixed greens", 6.0, "cups"),
                Ingredient("cherry tomatoes", 1.0, "cup"),
                Ingredient("cucumber", 1.0, ""),
                Ingredient("red onion", 0.25, "cup"),
                Ingredient("feta cheese", 0.5, "cup"),
                Ingredient("olive oil", 3.0, "tbsp"),
                Ingredient("balsamic vinegar", 2.0, "tbsp"),
                Ingredient("honey", 1.0, "tsp")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.fresh_garden_salad}"
        ),
        Recipe(
            name = "Homemade Pizza Dough",
            ingredients = listOf(
                Ingredient("bread flour", 3.0, "cups"),
                Ingredient("warm water", 1.0, "cup"),
                Ingredient("active dry yeast", 2.25, "tsp"),
                Ingredient("olive oil", 2.0, "tbsp"),
                Ingredient("salt", 1.0, "tsp"),
                Ingredient("sugar", 1.0, "tsp")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.homemade_pizza_dough}"
        ),
        Recipe(
            name = "Banana Smoothie Bowl",
            ingredients = listOf(
                Ingredient("frozen bananas", 2.0, ""),
                Ingredient("almond milk", 0.25, "cup"),
                Ingredient("vanilla protein powder", 1.0, "scoop"),
                Ingredient("honey", 1.0, "tbsp"),
                Ingredient("granola", 0.25, "cup"),
                Ingredient("fresh berries", 0.5, "cup"),
                Ingredient("chia seeds", 1.0, "tbsp")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.banana_smoothie_bowl}"
        ),
        Recipe(
            name = "Beef Stir Fry",
            ingredients = listOf(
                Ingredient("beef sirloin", 1.0, "lb"),
                Ingredient("broccoli florets", 2.0, "cups"),
                Ingredient("bell peppers", 2.0, ""),
                Ingredient("soy sauce", 3.0, "tbsp"),
                Ingredient("oyster sauce", 2.0, "tbsp"),
                Ingredient("sesame oil", 1.0, "tbsp"),
                Ingredient("garlic cloves", 3.0, ""),
                Ingredient("fresh ginger", 1.0, "tbsp"),
                Ingredient("green onions", 2.0, "")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.beef_stir_fry}"
        ),
        Recipe(
            name = "Lemon Herb Roasted Chicken",
            ingredients = listOf(
                Ingredient("whole chicken", 1.0, ""),
                Ingredient("lemons", 2.0, ""),
                Ingredient("fresh rosemary", 3.0, "sprigs"),
                Ingredient("fresh thyme", 2.0, "tbsp"),
                Ingredient("olive oil", 0.25, "cup"),
                Ingredient("garlic cloves", 4.0, ""),
                Ingredient("salt", 2.0, "tsp"),
                Ingredient("black pepper", 1.0, "tsp")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.lemon_herb_roasted_chicken}"
        ),
        Recipe(
            name = "Vegetarian Quinoa Bowl",
            ingredients = listOf(
                Ingredient("quinoa", 1.0, "cup"),
                Ingredient("sweet potato", 1.0, "large"),
                Ingredient("chickpeas", 1.0, "can"),
                Ingredient("spinach", 2.0, "cups"),
                Ingredient("avocado", 1.0, ""),
                Ingredient("tahini", 2.0, "tbsp"),
                Ingredient("lemon juice", 2.0, "tbsp"),
                Ingredient("olive oil", 1.0, "tbsp")
            ),
            imageUri = "android.resource://com.example.assignment_3/${R.drawable.vegetarian_quinoa_bowl}"
        )
    )
}