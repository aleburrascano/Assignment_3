package com.example.assignment_3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes

@Composable
fun RecipeDetailScreen(recipeName: String) {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    val recipe = viewModel.getRecipeByName(recipeName)

    MainLayout(screenTitle = "Recipe Details") {
        if (recipe == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Recipe not found")
                Button(onClick = { navController.navigate(Routes.RecipeList.route) }) {
                    Text(text = "Back to List")
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                if (recipe.imageUri.isNotBlank()) {
                    AsyncImage(
                        model = recipe.imageUri,
                        contentDescription = recipe.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Text(
                    text = "Ingredients:",
                    style = MaterialTheme.typography.titleMedium
                )

                Card(modifier = Modifier.fillMaxWidth()) {
                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        items(recipe.ingredients) { ingredient ->
                            Text(
                                text = "${ingredient.amount} ${ingredient.unit} ${ingredient.name}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { navController.navigate(Routes.RecipeList.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "View All Recipes")
                }
            }
        }
    }
}