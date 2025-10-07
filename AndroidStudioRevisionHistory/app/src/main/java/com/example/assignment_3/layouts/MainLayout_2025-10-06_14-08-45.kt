package com.example.assignment_3.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    screenTitle: String,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = { SharedTopBar(screenTitle) },
        bottomBar = { SharedBottomBar() }
    ) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}