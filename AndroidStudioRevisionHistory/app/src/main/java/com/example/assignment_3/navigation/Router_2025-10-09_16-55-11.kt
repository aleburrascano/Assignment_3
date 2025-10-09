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
import com.example.assignment_3.screens.AboutScreen
import com.example.assignment_3.screens.addrecipe.AddRecipeScreen
import com.example.assignment_3.screens.RecipeDetailScreen
import com.example.assignment_3.screens.recipelist.RecipeListScreen
import com.example.assignment_3.viewmodels.RecipeViewModel

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController found!")
}

val LocalRecipeViewModel = compositionLocalOf<RecipeViewModel> {
    error("No RecipeViewModel found!")
}

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

