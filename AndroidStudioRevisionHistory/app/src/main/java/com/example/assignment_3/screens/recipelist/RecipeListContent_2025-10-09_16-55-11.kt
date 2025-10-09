package com.example.assignment_3.screens.recipelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment_3.models.Recipe
import com.example.assignment_3.navigation.Routes

/**
 * Content displayed when recipes exist, including header and scrollable list.
 */
@Composable
fun RecipeListContent(
    recipes: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit,
    onDeleteClick: (Recipe) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "${viewModel.recipes.size} Recipe${if (viewModel.recipes.size != 1) "s" else ""}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = "Tap any recipe to view details",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        items(viewModel.recipes) { recipe ->
            RecipeListItem(
                recipe = recipe,
                onRecipeClick = {
                    navController.navigate(Routes.RecipeDetail.go(recipe.name))
                },
                onDeleteClick = {
                    viewModel.removeRecipe(recipe)
                }
            )
        }
    }
}