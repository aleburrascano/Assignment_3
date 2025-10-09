package com.example.assignment_3.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.assignment_3.screens.about.AboutScreen
import com.example.assignment_3.screens.addrecipe.AddRecipeScreen
import com.example.assignment_3.screens.recipedetails.RecipeDetailScreen
import com.example.assignment_3.screens.recipelist.RecipeListScreen
import com.example.assignment_3.viewmodels.RecipeViewModel

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController found!")
}

val LocalRecipeViewModel = compositionLocalOf<RecipeViewModel> {
    error("No RecipeViewModel found!")
}

/**
 * Main navigation router for the Recipe Tracker application.
 *
 * Sets up the navigation graph with all available screens and provides
 * shared dependencies through CompositionLocal providers.
 *
 * Features:
 * - Navigation between Add Recipe, Recipe List, Recipe Detail, and About screens
 * - Shared RecipeViewModel across all screens for state management
 * - NavController access throughout the app hierarchy
 * - Automatic argument extraction for Recipe Detail screen
 *
 * Navigation Flow:
 * - Start destination: Add Recipe screen
 * - Recipe Detail requires recipeName parameter from navigation arguments
 * - All screens have access to bottom navigation for quick switching
 *
 * @param modifier Optional modifier for the NavHost container
 */
@Composable
fun Router(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val recipeViewModel: RecipeViewModel = viewModel()

    CompositionLocalProvider(
        LocalNavController provides navController,
        LocalRecipeViewModel provides recipeViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.AddRecipe.route,
            modifier = modifier.fillMaxSize()
        ) {
            composable(Routes.AddRecipe.route) {
                AddRecipeScreen()
            }
            composable(Routes.RecipeDetail.route) {
                val recipeName = it.arguments?.getString("recipeName") ?: ""
                RecipeDetailScreen(recipeName)
            }
            composable(Routes.RecipeList.route) {
                RecipeListScreen()
            }
            composable(Routes.About.route) {
                AboutScreen()
            }

        }
    }
}

