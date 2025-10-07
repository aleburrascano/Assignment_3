package com.example.assignment_3.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.assignment_3.layouts.MainLayout

@Composable
fun AboutScreen() {
    MainLayout(screenTitle = "About") {
        Text(
            text = "Recipe Keeper",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = "A simple app to manage your favorite recipes!")
    }
}