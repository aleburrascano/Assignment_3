package com.example.assignment_3.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.Routes

@Composable
fun AddRecipeScreen() {
    val navController = LocalNavController.current

    MainLayout(screenTitle = "Add Recipe") {
        Button(onClick = { navController.navigate(Routes.RecipeList.route) }) {
            Text(text = "View All Recipes")
        }
    }
}