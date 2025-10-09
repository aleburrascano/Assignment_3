package com.example.assignment_3.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.assignment_3.navigation.LocalNavController

/**
 * Shared top app bar component used across all screens.
 *
 * Features:
 * - Centered screen title with app's typography
 * - Conditional back button (only shows when navigation stack has previous entries)
 * - Consistent primary color theming
 * - Automatic navigation handling for back button
 *
 * Design:
 * - Uses Material 3 CenterAlignedTopAppBar for modern appearance
 * - Primary color background with white text for strong branding
 * - Back arrow only appears when user can actually navigate back
 *
 * @param screenTitle Title to display in the center of the app bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopBar(screenTitle: String) {
    val navController = LocalNavController.current

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = screenTitle,
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(
                    onClick = {
                        if (navController.previousBackStackEntry != null) {
                            navController.navigateUp()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Go Back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}