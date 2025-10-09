package com.example.assignment_3.screens.recipelist

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Recipe image with fallback placeholder.
 */
@Composable
fun RecipeImage(
    imageUri: String,
    recipeName: String
) {
    if (imageUri.isNotBlank()) {
        AsyncImage(
            model = imageUri,
            contentDescription = recipeName,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    } else {
        RecipeImagePlaceholder()
    }
}