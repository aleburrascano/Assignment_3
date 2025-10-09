package com.example.assignment_3.screens.recipelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Recipe

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
            RecipeListHeader(recipeCount = recipes.size)
        }

        items(recipes) { recipe ->
            RecipeListItem(
                recipe = recipe,
                onRecipeClick = { onRecipeClick(recipe) },
                onDeleteClick = { onDeleteClick(recipe) }
            )
        }
    }
}