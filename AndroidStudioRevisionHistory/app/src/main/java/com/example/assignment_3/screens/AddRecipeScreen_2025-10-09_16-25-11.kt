package com.example.assignment_3.screens

import com.example.assignment_3.R
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.assignment_3.composables.AddIngredientDialog
import com.example.assignment_3.composables.IngredientsSection
import com.example.assignment_3.composables.RecipeNameInput
import com.example.assignment_3.composables.RecipePhotoSection
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.models.Recipe
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun AddRecipeScreen() {
    val navController = LocalNavController.current
    val viewModel = LocalRecipeViewModel.current

    var recipeName by rememberSaveable { mutableStateOf("") }
    var imageUri by rememberSaveable { mutableStateOf<String?>(null) }

    val ingredients = rememberSaveable { mutableStateListOf<Ingredient>() }
    var showIngredientDialog by rememberSaveable { mutableStateOf(false) }

    var showError by rememberSaveable { mutableStateOf(false) }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        imageUri = uri?.toString()
    }

    LaunchedEffect(showError) {
        if (showError) {
            delay(3000)
            showError = false
        }
    }

    MainLayout(screenTitle = "Add Recipe") {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                RecipeNameInput(
                    recipeName = recipeName,
                    onRecipeNameChange = {
                        recipeName = it
                        showError = false
                    }
                )

                RecipePhotoSection(
                    imageUri = imageUri,
                    recipeName = recipeName,
                    onPhotoClick = {
                        photoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
                )

                // Ingredients Section
                IngredientsSection(
                    ingredients = ingredients,
                    onAddIngredientClick = { showIngredientDialog = true },
                    onRemoveIngredient = { index -> ingredients.removeAt(index) }
                )

                // Save Button
                Button(
                    onClick = {
                        when {
                            recipeName.isBlank() -> {
                                showError = true
                                errorMessage = "Please enter a recipe name"
                            }
                            recipeName.length < 3 -> {
                                showError = true
                                errorMessage = "Recipe name must be at least 3 characters long"
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "Save Recipe",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            if (showIngredientDialog) {
                AddIngredientDialog(
                    onDismiss = { showIngredientDialog = false },
                    onAdd = { ingredient ->
                        ingredients.add(ingredient)
                        showIngredientDialog = false
                    },
                    onError = { message ->
                        showIngredientDialog = false
                        showError = true
                        errorMessage = message
                    }
                )
            }

            // Error Snackbar at Top
            AnimatedVisibility(
                visible = showError,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.errorContainer,
                    shadowElevation = 8.dp,
                    tonalElevation = 16.dp
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = errorMessage,
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.weight(1f)
                        )

                        IconButton(
                            onClick = { showError = false },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}