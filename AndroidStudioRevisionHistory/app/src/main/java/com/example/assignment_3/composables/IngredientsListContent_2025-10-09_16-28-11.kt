package com.example.assignment_3.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient

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

        }
    }
}