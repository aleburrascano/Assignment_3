package com.example.assignment_3.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController found!")
}

@Composable
fun Router(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = ,
            modifier = modifier.fillMaxSize()
        )
    }
}