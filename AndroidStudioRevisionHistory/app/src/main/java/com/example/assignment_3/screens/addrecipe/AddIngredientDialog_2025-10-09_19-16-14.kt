package com.example.assignment_3.screens.addrecipe

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.models.Ingredient
import androidx.compose.ui.window.Dialog
import com.example.assignment_3.R

/**
 * Modal dialog for adding new ingredients to a recipe.
 *
 * Features:
 * - Ingredient name input (required)
 * - Amount input (optional, validates numeric values)
 * - Unit input (optional, e.g., "cups", "tbsp")
 * - Form validation with error callbacks
 * - Automatic field clearing after successful addition
 *
 * Validation Rules:
 * - Ingredient name cannot be blank
 * - Amount must be a valid positive number if provided
 * - Unit field is completely optional
 *
 * @param onDismiss Callback when dialog should be closed (cancel or backdrop tap)
 * @param onAdd Callback when ingredient is successfully added (receives Ingredient object)
 * @param onError Callback for validation errors (receives error message string)
 */
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
                    text = stringResource(R.string.add_ingredient),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )

                OutlinedTextField(
                    value = ingredientName,
                    onValueChange = { ingredientName = it },
                    label = { Text(text = stringResource(R.string.ingredient_name)) },
                    placeholder = { Text(text = stringResource(R.string.flour)) },
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
                        label = { Text(text = stringResource(R.string.amount)) },
                        placeholder = { Text(text = stringResource(R.string._2)) },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    OutlinedTextField(
                        value = ingredientUnit,
                        onValueChange = { ingredientUnit = it },
                        label = { Text(text = stringResource(R.string.unit)) },
                        placeholder = { Text(text = stringResource(R.string.cups)) },
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
                        Text(text = stringResource(R.string.cancel))
                    }

                    Button(
                        onClick = {
                            when {
                                ingredientName.isBlank() -> {
                                    onError(context.getString(R.string.please_enter_an_ingredient_name))
                                }
                                ingredientAmount.isNotBlank() && ingredientAmount.toDoubleOrNull() == null -> {
                                    onError(context.getString(R.string.amount_must_be_a_valid_number))
                                }
                                ingredientAmount.toDoubleOrNull()?.let { it <= 0.0 } == true -> {
                                    onError(context.getString(R.string.amount_must_be_greater_than_0))
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
                        Text(text = stringResource(R.string.add))
                    }
                }
            }
        }
    }
}