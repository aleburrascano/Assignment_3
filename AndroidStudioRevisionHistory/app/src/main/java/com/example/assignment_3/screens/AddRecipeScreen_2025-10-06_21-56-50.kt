package com.example.assignment_3.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.models.Recipe
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes
import androidx.core.net.toUri

@Composable
fun AddRecipeScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    var recipeName by rememberSaveable { mutableStateOf("") }
    var imageUri by rememberSaveable { mutableStateOf<String?>(null) }

    val ingredients = rememberSaveable { mutableStateListOf<Ingredient>() }
    var ingredientName by rememberSaveable { mutableStateOf("") }
    var ingredientAmount by rememberSaveable { mutableStateOf("") }
    var ingredientUnit by rememberSaveable { mutableStateOf("") }

    var showError by rememberSaveable { mutableStateOf(false) }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        imageUri = uri?.toString()
    }

    MainLayout(screenTitle = "Add Recipe") {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = recipeName,
                onValueChange = {
                    recipeName = it
                    showError = false
                },
                label = { Text(text = "Recipe Name") },
                placeholder = { Text(text = "e.g., Chocolate Chip Cookies") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                   modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (imageUri != null) {
                        AsyncImage(
                            model = imageUri,
                            contentDescription = recipeName,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "No image",
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Text(
                text = "Create a New Recipe",
                style = MaterialTheme.typography.headlineSmall
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Column {

                    Button(
                        onClick = {
                            photoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        },
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(text = if (imageUri == null) "Pick Image" else "Change Image")
                    }
                }
            }

            HorizontalDivider()

            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = ingredientAmount,
                    onValueChange = { ingredientAmount = it },
                    label = { Text(text = "Amount") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )

                OutlinedTextField(
                    value = ingredientUnit,
                    onValueChange = { ingredientUnit = it },
                    label = { Text(text = "Unit") },
                    placeholder = { Text(text = "e.g., cups") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }

            OutlinedTextField(
                value = ingredientName,
                onValueChange = { ingredientName = it },
                label = { Text(text = "Ingredient Name") },
                placeholder = { Text(text = "e.g., flour")},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Button(
                onClick = {
                    if (ingredientName.isNotBlank()) {
                        ingredients.add(
                            Ingredient(
                                name = ingredientName.trim(),
                                amount = ingredientAmount.toDoubleOrNull() ?: 0.0,
                                unit = ingredientUnit.trim()
                            )
                        )
                        ingredientName = ""
                        ingredientAmount = ""
                        ingredientUnit = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Add Ingredient")
            }

            if (ingredients.isNotEmpty()) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    LazyColumn(modifier = Modifier.padding(8.dp)) {
                        itemsIndexed(ingredients) { index, ingredient ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "${ingredient.amount} ${ingredient.unit} ${ingredient.name}")
                                TextButton(onClick = { ingredients.removeAt(index) }) {
                                    Text(text = "Remove")
                                }
                            }
                        }
                    }
                }
            }

            if (showError) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    when {
                        recipeName.isBlank() -> {
                            showError = true
                            errorMessage = "Please enter a recipe name"
                        }
                        ingredients.isEmpty() -> {
                            showError = true
                            errorMessage = "Please add at least one ingredient"
                        }
                        else -> {
                            viewModel.addRecipe(
                                Recipe(
                                    name = recipeName.trim(),
                                    ingredients = ingredients.toList(),
                                    imageUri = imageUri ?: ""
                                )
                            )
                            navController.navigate(Routes.RecipeDetail.go(recipeName.trim()))
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Save Recipe")
            }
        }
    }
}