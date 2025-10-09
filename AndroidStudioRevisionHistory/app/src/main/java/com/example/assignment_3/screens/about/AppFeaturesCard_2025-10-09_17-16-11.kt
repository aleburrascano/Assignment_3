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
                text = "Features",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            FeatureItem(
                icon = Icons.Default.Edit,
                title = "Easy Creation",
                description = "Create and save recipes with simple steps"
            )

            FeatureItem(
                icon = Icons.Default.Star,
                title = "Photo Support",
                description = "Add beautiful photos to your recipes"
            )

            FeatureItem(
                icon = Icons.Default.CheckCircle,
                title = "Ingredient Tracking",
                description = "Organize ingredients with precise measurements"
            )

            FeatureItem(
                painter = painterResource(R.drawable.material_symbols_outlined_restaurant),
                title = "Quick Access",
                description = "Find and view your recipes instantly"
            )
        }
    }
}