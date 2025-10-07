package com.example.assignment_3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel

@Composable
fun RecipeListScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    MainLayout(screenTitle = "My Recipes") {
        if (viewModel.recipes.isEmpty()) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "No recipes yet",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Add your first recipe to get started!",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}