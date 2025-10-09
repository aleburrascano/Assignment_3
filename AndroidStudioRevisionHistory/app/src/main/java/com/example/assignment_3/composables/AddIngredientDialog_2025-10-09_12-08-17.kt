package com.example.assignment_3.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient
import androidx.compose.ui.window.Dialog

@Composable
fun AddIngredientDialog(
    onDismiss: () -> Unit,
    onAdd: (Ingredient) -> Unit,
    onError: (String) -> Unit
) {
    var ingredientName by rememberSaveable { mutableStateOf("") }
    var ingredientAmount by rememberSaveable { mutableStateOf("") }
    var ingredientUnit by rememberSaveable { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Add Ingredient",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = ingredientName,
                    onValueChange = { ingredientName = it },
                    label = { Text(text = "Ingredient Name") },
                    placeholder = { Text(text = "e.g., flour") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedTextField(
                        value = ingredientAmount,
                        onValueChange = { ingredientAmount = it },
                        label = { Text(text = "Amount") },
                        placeholder = { Text(text = "2") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    OutlinedTextField(
                        value = ingredientUnit,
                        onValueChange = { ingredientUnit = it },
                        label = { Text(text = "Unit") },
                        placeholder = { Text(text = "cups") },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Cancel")
                    }

                    Button(
                        onClick = {
                            when {
                                ingredientName.isBlank() -> {
                                    onError("Please enter an ingredient name")
                                }
                                ingredientAmount.isNotBlank() && ingredientAmount.toDoubleOrNull() == null -> {
                                    onError("Amount must be a valid number")
                                }
                                ingredientAmount.toDoubleOrNull()?.let { it <= 0.0 } == true -> {
                                    onError("Amount must be greater than 0")
                                }
                                else -> {
                                    onAdd(
                                        Ingredient(
                                            name = ingredientName.trim(),
                                            amount = ingredientAmount.toDoubleOrNull() ?: 0.0,
                                            unit = ingredientUnit.trim()
                                        )
                                    )
                                }
                            }
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text(text = "Add")
                    }
                }
            }
        }
    }
}