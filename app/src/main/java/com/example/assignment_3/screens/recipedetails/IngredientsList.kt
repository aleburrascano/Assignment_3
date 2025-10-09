package com.example.assignment_3.screens.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient

/**
 * List of all ingredients with measurements.
 */
@Composable
fun IngredientsList(ingredients: List<Ingredient>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ingredients.forEach { ingredient ->
            IngredientListItem(ingredient = ingredient)
        }
    }
}