package com.example.assignment_3.screens.recipedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assignment_3.R

/**
 * Error state icon with restaurant symbol.
 */
@Composable
fun ErrorStateIcon() {
    Surface(
        modifier = Modifier.size(100.dp),
        shape = RoundedCornerShape(50.dp),
        color = MaterialTheme.colorScheme.errorContainer
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(R.drawable.material_symbols_outlined_restaurant),
                contentDescription = stringResource(R.string.restaurant_utensils),
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}