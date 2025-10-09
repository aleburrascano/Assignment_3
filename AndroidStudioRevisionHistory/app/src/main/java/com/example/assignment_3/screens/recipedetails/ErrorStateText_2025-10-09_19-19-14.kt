package com.example.assignment_3.screens.recipedetails

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.assignment_3.R

/**
 * Error state messaging.
 */
@Composable
fun ErrorStateText() {
    Text(
        text = stringResource(R.string.recipe_not_found),
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground
    )

    Text(
        text = stringResource(R.string.this_recipe_doesn_t_exist_or_was_deleted),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}