package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

/**
 * Feature item using a painter resource.
 *
 * @param painter Painter resource to display
 * @param title Feature title
 * @param description Feature description
 */
@Composable
fun FeatureItemPainter(
    painter: Painter,
    title: String,
    description: String
) {
    FeatureItemLayout(
        icon = {
            Icon(
                painter = painter,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        },
        title = title,
        description = description
    )
}