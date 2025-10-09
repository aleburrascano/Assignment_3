package com.example.assignment_3.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient

/**
 * List content showing all added ingredients with remove functionality.
 */
@Composable
fun IngredientsListContent(
    ingredients: List<Ingredient>,
    onRemoveIngredient: (Int) -> Unit
) {
    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

    Text(
        text = "${ingredients.size} ingredient${if (ingredients.size != 1) "s" else ""} added",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )

    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        ingredients.forEachIndexed { index, ingredient ->
            IngredientListItem(
                ingredient = ingredient,
                onRemove = { onRemoveIngredient(index) }
            )
        }
    }
}