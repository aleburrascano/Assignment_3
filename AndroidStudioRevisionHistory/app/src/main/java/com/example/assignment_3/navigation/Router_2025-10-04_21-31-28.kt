package com.example.assignment_3.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController found!")
}

@Composable
fun Router(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = Routes.AddRecipe.route,
            modifier = modifier.fillMaxSize()
        ) {
            composable(Routes.AddRecipe.route) {
                // AddRecipeScreen
            }
            composable(Routes.RecipeDetail.route) {
                val recipeName = it.arguments?.getString("recipeName") ?: ""
                // RecipeDetailScreen
            }
            composable(Routes.RecipeList.route) {
                // RecipeListScreen
            }
            composable(Routes.About.route) {
                // AboutScreen
            }
        }
    }
}

