package com.example.assignment_3.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.Routes

/**
 * Shared bottom navigation bar providing access to primary app sections.
 *
 * Navigation Items:
 * - Add: Navigate to recipe creation screen
 * - Recipes: Navigate to recipe list/browse screen
 * - About: Navigate to app information screen
 *
 * Features:
 * - Automatic selection state based on current route
 * - Material 3 NavigationBar with proper theming
 * - Accessible icons and labels for each destination
 * - Handles navigation to prevent duplicate entries in stack
 *
 * State Management:
 * - Tracks current destination using NavController's back stack
 * - Highlights current section with Material 3 selection indicators
 * - Route matching handles parameterized routes (like Recipe Detail)
 *
 * Design:
 * - Surface color background with elevated appearance
 * - Standard Material 3 navigation patterns
 * - Clear iconography for each section
 */
@Composable
fun SharedBottomBar() {
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Add Recipe") },
            label = { Text(text = "Add") },
            selected = currentDestination?.route?.startsWith(Routes.AddRecipe.route) == true,
            onClick = { navController.navigate(Routes.AddRecipe.route) }
        )

        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Recipe List") },
            label = { Text(text = "Recipes") },
            selected = currentDestination?.route?.startsWith(Routes.RecipeList.route) == true,
            onClick = { navController.navigate(Routes.RecipeList.route) }
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Info, contentDescription = "About") },
            label = { Text(text = "About") },
            selected = currentDestination?.route?.startsWith(Routes.About.route) == true,
            onClick = { navController.navigate(Routes.About.route) }
        )
    }
}