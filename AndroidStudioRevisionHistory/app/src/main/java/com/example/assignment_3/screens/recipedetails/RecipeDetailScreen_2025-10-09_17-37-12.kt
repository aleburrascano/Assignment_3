package com.example.assignment_3.screens.recipedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.example.assignment_3.R
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes

/**
 * Detailed view of a single recipe showing all information.
 *
 * Features:
 * - Recipe name in highlighted header card
 * - Large recipe image with fallback placeholder
 * - Comprehensive ingredients list with measurements
 * - Navigation back to recipe list
 * - Error state handling for missing recipes
 * - Scrollable content for long ingredient lists
 *
 * @param recipeName Name of the recipe to display (passed from navigation)
 */
@Composable
fun RecipeDetailScreen(recipeName: String) {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    val recipe = viewModel.getRecipeByName(recipeName)

    MainLayout(screenTitle = "Recipe Details") {
        if (recipe == null) {
            RecipeNotFoundState(
                onBackClick = {
                    navController.navigate(Routes.RecipeList.route)
                }
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                RecipeNameHeader(recipe.name)

                RecipeImageSection(
                    imageUri = recipe.imageUri,
                    recipeName = recipe.name
                )



                Spacer(modifier = Modifier.height(4.dp))
                
                Button(
                    onClick = { navController.navigate(Routes.RecipeList.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "View All Recipes",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}