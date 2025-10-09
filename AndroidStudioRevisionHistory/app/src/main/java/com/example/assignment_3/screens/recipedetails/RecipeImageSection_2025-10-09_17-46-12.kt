package com.example.assignment_3.screens.recipedetails

import androidx.compose.runtime.Composable

/**
 * Recipe image display with fallback placeholder for missing images.
 *
 * @param imageUri Recipe image URI (empty string if no image)
 * @param recipeName Recipe name for accessibility
 */
@Composable
fun RecipeImageSection(
    imageUri: String,
    recipeName: String
) {
    if (imageUri.isNotBlank()) {
        RecipeImage(
            imageUri = imageUri,
            recipeName = recipeName
        )
    } else {
        RecipeImagePlaceholder()
    }
}