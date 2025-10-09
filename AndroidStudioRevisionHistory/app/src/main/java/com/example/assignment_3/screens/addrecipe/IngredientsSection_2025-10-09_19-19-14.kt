package com.example.assignment_3.screens.addrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.R
import com.example.assignment_3.models.Ingredient

/**
 * Section for managing recipe ingredients with add button and ingredient list.
 *
 * @param ingredients List of current ingredients
 * @param onAddIngredientClick Callback when add ingredient button is clicked
 * @param onRemoveIngredient Callback when an ingredient is removed (receives index)
 */
@Composable
fun IngredientsSection(
    ingredients: List<Ingredient>,
    onAddIngredientClick: () -> Unit,
    onRemoveIngredient: (Int) -> Unit
) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.ingredients),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                FilledIconButton(
                    onClick = onAddIngredientClick,
                    modifier = Modifier.size(32.dp),
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.add_ingredient),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }

            // Ingredients List
            if (ingredients.isEmpty()) {
                EmptyIngredientsState()
            } else {
                IngredientsListContent(
                    ingredients = ingredients,
                    onRemoveIngredient = onRemoveIngredient
                )
            }
        }
    }
}