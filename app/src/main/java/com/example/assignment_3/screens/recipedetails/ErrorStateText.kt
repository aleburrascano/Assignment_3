package com.example.assignment_3.screens.recipedetails

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

/**
 * Error state messaging.
 */
@Composable
fun ErrorStateText() {
    Text(
        text = "Recipe Not Found",
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground
    )

    Text(
        text = "This recipe doesn't exist or was deleted",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}