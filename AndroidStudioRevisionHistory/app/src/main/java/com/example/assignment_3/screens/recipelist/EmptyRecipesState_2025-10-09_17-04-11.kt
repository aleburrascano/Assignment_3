package com.example.assignment_3.screens.recipelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Empty state component shown when no recipes have been created yet.
 * Includes motivational messaging and a call-to-action button.
 *
 * @param onAddRecipeClick Callback when "Add Your First Recipe" button is clicked
 */
@Composable
fun EmptyRecipesState(
    onAddRecipeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        EmptyStateIcon()
        EmptyStateText()

        Spacer(modifier = Modifier.height(8.dp))

        AddFirstRecipeButton(onClick = onAddRecipeClick)
    }
}