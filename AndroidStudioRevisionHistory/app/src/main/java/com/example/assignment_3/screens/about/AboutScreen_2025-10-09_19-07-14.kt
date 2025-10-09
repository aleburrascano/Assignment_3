package com.example.assignment_3.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment_3.layouts.MainLayout

/**
 * Informational screen about the Recipe Tracker application.
 *
 * Features:
 * - Prominent app branding with icon and title
 * - Descriptive overview of app purpose
 * - Feature highlights with icons and descriptions
 * - Version information and credits
 * - Scrollable content for accessibility
 * - Professional layout with consistent spacing
 */
@Composable
fun AboutScreen() {
    MainLayout(screenTitle = "About") {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            AppBrandingSection()

            Spacer(modifier = Modifier.height(8.dp))

            AppDescriptionCard()

            AppFeaturesCard()

            VersionInfoCard()

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}