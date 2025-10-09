package com.example.assignment_3.screens.recipelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment_3.R

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
        Surface(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painter = painterResource(R.drawable.material_symbols_outlined_restaurant),
                    contentDescription = "No photo",
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}