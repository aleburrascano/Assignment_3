package com.example.assignment_3.screens.addrecipe

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.assignment_3.R
import com.example.assignment_3.layouts.MainLayout
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.navigation.LocalNavController
import com.example.assignment_3.navigation.LocalRecipeViewModel
import com.example.assignment_3.navigation.Routes
import kotlinx.coroutines.delay

/**
 * Main screen for adding new recipes to the collection.
 *
 * Features:
 * - Recipe name input with validation
 * - Photo selection from device gallery
 * - Ingredient management through modal dialog
 * - Form validation with animated error messages
 * - Automatic navigation to recipe detail after saving
 */
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

    MainLayout(screenTitle = stringResource(R.string.add_recipe)) {
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

                IngredientsSection(
                    ingredients = ingredients,
                    onAddIngredientClick = { showIngredientDialog = true },
                    onRemoveIngredient = { index -> ingredients.removeAt(index) }
                )

                SaveRecipeButton(
                    recipeName = recipeName,
                    ingredients = ingredients,
                    imageUri = imageUri,
                    onError = { message ->
                        showError = true
                        errorMessage = message
                    },
                    onSave = { recipe ->
                        viewModel.addRecipe(recipe)
                        navController.navigate(Routes.RecipeDetail.go(recipeName.trim()))
                    }
                )

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

            AnimatedVisibility(
                visible = showError,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                ErrorSnackbar(
                    message = errorMessage,
                    onDismiss = { showError = false }
                )
            }
        }
    }
}