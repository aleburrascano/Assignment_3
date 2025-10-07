package com.example.assignment_3.models

data class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val imageUri: String = ""
)
