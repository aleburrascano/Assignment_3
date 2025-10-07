package com.example.assignment_3.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController

@Composable
fun RecipeListScreen() {
    val navController = LocalNavController.current

    MainLayout(screenTitle = "My Recipes") {
        Text(text = "Recipe List Screen")
    }
}