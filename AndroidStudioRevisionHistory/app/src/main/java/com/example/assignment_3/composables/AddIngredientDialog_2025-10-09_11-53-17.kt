package com.example.assignment_3.composables

import android.app.Dialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.assignment_3.models.Ingredient

@Composable
fun AddIngredientDialog(
    onDismiss: () -> Unit,
    onAdd: (Ingredient) -> Unit,
    onError: (String) -> Unit
) {
    var ingredientName by rememberSaveable { mutableStateOf("") }
    var ingredientAmount by rememberSaveable { mutableStateOf("") }
    var ingredientUnit by rememberSaveable { mutableStateOf("") }

    Dia
}