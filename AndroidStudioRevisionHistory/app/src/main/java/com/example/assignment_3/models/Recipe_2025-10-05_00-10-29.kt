package com.example.assignment_3.models

import android.net.Uri

data class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val imageUri: Uri? = null
)
