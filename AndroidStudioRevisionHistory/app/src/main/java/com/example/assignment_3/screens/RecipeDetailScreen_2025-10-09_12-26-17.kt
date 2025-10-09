package com.example.assignment_3.screens

import com.example.assignment_3.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
            // Recipe not found state
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Surface(
                        modifier = Modifier.size(100.dp),
                        shape = RoundedCornerShape(50.dp),
                        color = MaterialTheme.colorScheme.errorContainer
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                painter = painterResource(R.drawable.material_symbols_outlined_restaurant),
                                contentDescription = "Restaurant utensils",
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }

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

                    Button(
                        onClick = { navController.navigate(Routes.RecipeList.route) },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Back to Recipes")
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    
                }
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