package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.R

/**
 * Card showcasing the main features of the application.
 * Each feature includes an icon, title, and description.
 */
@Composable
fun AppFeaturesCard() {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.features),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            FeatureItemImageVector(
                icon = Icons.Default.Edit,
                title = stringResource(R.string.easy_creation),
                description = stringResource(R.string.create_and_save_recipes_with_simple_steps)
            )

            FeatureItemImageVector(
                icon = Icons.Default.Star,
                title = stringResource(R.string.photo_support),
                description = stringResource(R.string.add_beautiful_photos_to_your_recipes)
            )

            FeatureItemImageVector(
                icon = Icons.Default.CheckCircle,
                title = "Ingredient Tracking",
                description = stringResource(R.string.organize_ingredients_with_precise_measurements)
            )

            FeatureItemPainter(
                painter = painterResource(R.drawable.material_symbols_outlined_restaurant),
                title = stringResource(R.string.quick_access),
                description = stringResource(R.string.find_and_view_your_recipes_instantly)
            )
        }
    }
}