package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Individual feature item with icon, title, and description.
 * Supports both vector icons and painter resources for maximum flexibility.
 *
 * The icon is displayed in a rounded container with primary color theming,
 * and the text content is laid out in a column to the right.
 */

/**
 * Feature item using a vector icon.
 *
 * @param icon Vector icon to display
 * @param title Feature title
 * @param description Feature description
 */
@Composable
fun FeatureItem(
    icon: ImageVector,
    title: String,
    description: String
) {
    FeatureItemLayout(
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        },
        title = title,
        description = description
    )
}

/**
 * Feature item using a painter resource.
 *
 * @param painter Painter resource to display
 * @param title Feature title
 * @param description Feature description
 */
@Composable
fun FeatureItem(
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

/**
 * Common layout for feature items with icon container and text content.
 */
@Composable
private fun FeatureItemLayout(
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

/**
 * Rounded container for feature icons.
 */
@Composable
private fun FeatureIconContainer(
    icon: @Composable () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier.size(48.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            icon()
        }
    }
}

/**
 * Text content section with title and description.
 */
@Composable
private fun FeatureTextContent(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}