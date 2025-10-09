package com.example.assignment_3.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.models.Recipe
import com.example.assignment_3.navigation.Routes
import kotlin.collections.toList

@Composable
fun SaveRecipeButton(
    recipeName: String,
    ingredients: List<Ingredient>,
    imageUri: String?,
    onError: (String) -> Unit,
    onSave: (Recipe) -> Unit
) {
    Button(
        onClick = {
            when {
                recipeName.isBlank() -> {
                    showError = true
                    errorMessage = "Please enter a recipe name"
                }
                recipeName.length < 3 -> {
                    showError = true
                    errorMessage = "Recipe name must be at least 3 characters long"
                }
                ingredients.isEmpty() -> {
                    showError = true
                    errorMessage = "Please add at least one ingredient"
                }
                else -> {
                    viewModel.addRecipe(
                        Recipe(
                            name = recipeName.trim(),
                            ingredients = ingredients.toList(),
                            imageUri = imageUri ?: ""
                        )
                    )
                    navController.navigate(Routes.RecipeDetail.go(recipeName.trim()))
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = "Save Recipe",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}