package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Common layout for feature items with icon container and text content.
 */
@Composable
fun FeatureItemLayout(
    icon: @Composable () -> Unit,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FeatureIconContainer(icon = icon)

        FeatureTextContent(
            title = title,
            description = description
        )
    }
}