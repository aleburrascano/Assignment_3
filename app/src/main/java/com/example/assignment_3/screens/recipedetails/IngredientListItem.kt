package com.example.assignment_3.screens.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient

/**
 * Individual ingredient display item with bullet point and measurements.
 *
 * Features:
 * - Colored bullet point indicator
 * - Ingredient name prominently displayed
 * - Amount and unit on separate line (only if provided)
 * - Consistent styling with other ingredient displays
 *
 * @param ingredient Ingredient data to display
 */
@Composable
fun IngredientListItem(ingredient: Ingredient) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(8.dp)
            ) {}

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = ingredient.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium
                )

                if (ingredient.amount > 0.0 || ingredient.unit.isNotBlank()) {
                    Text(
                        text = "${ingredient.amount} ${ingredient.unit}".trim(),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}