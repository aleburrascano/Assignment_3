package com.example.assignment_3.navigation

sealed class Routes(val route: String) {
    object AddRecipe : Routes("AddRecipeRoute")
    object RecipeDetail : Routes("RecipeDetailRoute/{recipeName}") {
        fun go(recipeName: String) = "RecipeDetailRoute/$recipeName"
    }
    object RecipeList : Routes("RecipeListRoute")
    object About : Routes("AboutRoute")
}