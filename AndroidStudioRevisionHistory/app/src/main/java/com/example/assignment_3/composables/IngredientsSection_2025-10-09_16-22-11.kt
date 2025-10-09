package com.example.assignment_3.composables

import androidx.compose.runtime.Composable
import com.example.assignment_3.models.Ingredient

@Composable
fun IngredientsSection(
    ingredients: List<Ingredient>,
    onAddIngredientClick: () -> Unit,
    onRemoveIngredient: (Int) -> Unit
) {
    
}