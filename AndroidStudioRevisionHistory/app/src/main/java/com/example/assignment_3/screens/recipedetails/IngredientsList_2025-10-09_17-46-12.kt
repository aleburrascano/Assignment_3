package com.example.assignment_3.screens.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun IngredientsList() {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ingredients.forEach { ingredient ->
            IngredientListItem(ingredient = ingredient)
        }
    }
}