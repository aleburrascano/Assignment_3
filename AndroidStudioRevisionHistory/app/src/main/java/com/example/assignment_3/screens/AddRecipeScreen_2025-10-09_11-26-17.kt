package com.example.assignment_3.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = recipeName,
                    onValueChange = {
                        recipeName = it
                        showError = false
                    },
                    label = { Text("Recipe Name") },
                    placeholder = { Text(text = "e.g., Chocolate Chip Cookies") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary
                    )
                )

                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (imageUri != null) {
                                AsyncImage(
                                    model = imageUri,
                                    contentDescription = recipeName,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(MaterialTheme.colorScheme.surfaceVariant),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "No image",
                                        modifier = Modifier.size(32.dp),
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }

                        OutlinedButton(
                            onClick = {
                                photoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Image",
                                modifier = Modifier.size(18.dp)
                            )

                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = if (imageUri == null) "Add Image" else "Change Image")
                        }
                    }
                }

                HorizontalDivider()

                Text(
                    text = "Ingredients",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = ingredientAmount,
                        onValueChange = { ingredientAmount = it },
                        label = { Text(text = "Amount") },
                        placeholder = { Text(text = "2") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                    )

                    OutlinedTextField(
                        value = ingredientUnit,
                        onValueChange = { ingredientUnit = it },
                        label = { Text(text = "Unit") },
                        placeholder = { Text(text = "cups") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                    )
                }

                OutlinedTextField(
                    value = ingredientName,
                    onValueChange = { ingredientName = it },
                    label = { Text(text = "Ingredient") },
                    placeholder = { Text(text = "flour")},
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                )

                Button(
                    onClick = {
                        when {
                            ingredientName.isBlank() -> {
                                showError = true
                                errorMessage = "Please enter an ingredient name"
                            }
                            ingredientAmount.isNotBlank() && ingredientAmount.toDoubleOrNull() == null -> {
                                showError = true
                                errorMessage = "Amount must be a valid number"
                            }
                            ingredientAmount.toDoubleOrNull()?.let { it <= 0 } == true -> {
                                showError = true
                                errorMessage = "Amount must be greater than 0"
                            }
                            else -> {
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
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Add Ingredient")
                }

                if (ingredients.isNotEmpty()) {
                    HorizontalDivider()

                    Text(
                        text = "${ingredients.size} ingredient${if (ingredients.size != 1) "s" else ""} added",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        itemsIndexed(ingredients) { index, ingredient ->
                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "• ${ingredient.amount} ${ingredient.unit} ${ingredient.name}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.weight(1f)
                                    )

                                    IconButton(
                                        onClick = { ingredients.removeAt(index) },
                                        modifier = Modifier.size(36.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Remove",
                                            tint = MaterialTheme.colorScheme.error,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                if (showError) {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.errorContainer
                    ) {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }

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
        }
    }
}