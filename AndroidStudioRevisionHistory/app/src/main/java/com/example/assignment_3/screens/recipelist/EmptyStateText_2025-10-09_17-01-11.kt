package com.example.assignment_3.screens.recipelist

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

/**
 * Motivational text for empty state.
 */

@Composable
fun EmptyStateText() {
    Text(
        text = "No Recipes Yet",
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground
    )

    Text(
        text = "Start building your recipe collection!",
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}