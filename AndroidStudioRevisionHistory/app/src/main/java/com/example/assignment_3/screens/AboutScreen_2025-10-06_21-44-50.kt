package com.example.assignment_3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment_3.layouts.MainLayout

@Composable
fun AboutScreen() {
    MainLayout(screenTitle = "About") {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Surface(
                modifier = Modifier.size(120.dp),
                shape = MaterialTheme.shapes.extraLarge,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Recipe Tracker",
                        modifier = Modifier.size(64.dp),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Text
        }
    }
//    MainLayout(screenTitle = "About") {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(24.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(20.dp)
//        ) {
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Icon(
//                imageVector = Icons.Default.LocationOn,
//                contentDescription = "Recipe Keeper Icon",
//                modifier = Modifier.size(80.dp),
//                tint = MaterialTheme.colorScheme.primary
//            )
//
//            Text(
//                text = "Recipe Keeper",
//                style = MaterialTheme.typography.titleMedium,
//                color = MaterialTheme.colorScheme.onSurfaceVariant
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Card(modifier = Modifier.fillMaxWidth()) {
//                Column(
//                    modifier = Modifier.padding(16.dp),
//                    verticalArrangement = Arrangement.spacedBy(12.dp)
//                ) {
//                    Text(
//                        text = "Features",
//                        style = MaterialTheme.typography.titleLarge
//                    )
//
//                    Text(text = "Create and save your favorite recipes")
//                    Text(text = "Add photos to your recipes")
//                    Text(text = "Organize ingredients with measurements")
//                    Text(text = "Easy recipe management")
//                }
//            }
//        }
//    }
}