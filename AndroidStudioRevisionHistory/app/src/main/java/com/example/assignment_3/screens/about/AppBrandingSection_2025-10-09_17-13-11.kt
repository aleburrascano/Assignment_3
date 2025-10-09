package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

/**
 * App branding section with large icon, title, and tagline.
 * Creates a professional first impression for the about screen.
 */
@Composable
fun AppBrandingSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppIcon()

        AppTitleAndTagline()
    }
}