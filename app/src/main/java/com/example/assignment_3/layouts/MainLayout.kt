package com.example.assignment_3.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Standard layout wrapper for all screens in the Recipe Tracker app.
 *
 * Provides consistent structure with:
 * - Top app bar with screen title and back navigation
 * - Bottom navigation bar for primary screen switching
 * - Content area with proper padding to avoid overlaps
 * - Material 3 Scaffold foundation for proper layout behavior
 *
 * The layout automatically handles:
 * - System bar insets and padding
 * - Navigation bar spacing
 * - Back button visibility (only shows when there's a previous screen)
 *
 * @param screenTitle Title displayed in the top app bar
 * @param content Screen content to display in the main area
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    screenTitle: String,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = { SharedTopBar(screenTitle) },
        bottomBar = { SharedBottomBar() }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}