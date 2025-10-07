package com.example.assignment_3.layouts

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.assignment_3.navigation.LocalNavController

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
                IconButton(onClick) { }
            }
        }
    )
}