package com.example.assignment_3.screens.recipelist

import com.example.assignment_3.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes
import com.example.assignment_3.models.Recipe

/**
 * Main screen displaying a list of all saved recipes.
 *
 * Features:
 * - Empty state with call-to-action when no recipes exist
 * - Scrollable list of recipe cards with thumbnails
 * - Recipe count header with helpful instructions
 * - Click navigation to recipe details
 * - Delete functionality with confirmation
 * - Responsive layout with proper spacing
 */
@Composable
fun RecipeListScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    var recipeToDelete by rememberSaveable { mutableStateOf<Recipe?>(null) }

    MainLayout(screenTitle = stringResource(R.string.my_recipes)) {
        if (viewModel.recipes.isEmpty()) {
            EmptyRecipesState(
                onAddRecipeClick = {
                    navController.navigate(Routes.AddRecipe.route)
                }
            )
        } else {
            RecipeListContent(
                recipes = viewModel.recipes,
                onRecipeClick = { recipe ->
                    navController.navigate(Routes.RecipeDetail.go(recipe.name))
                },
                onDeleteClick = { recipe ->
                    viewModel.removeRecipe(recipe)
                }
            )
        }
    }
}