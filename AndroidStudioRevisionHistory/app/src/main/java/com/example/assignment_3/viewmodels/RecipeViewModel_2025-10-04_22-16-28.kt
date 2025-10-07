package com.example.assignment_3.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.assignment_3.models.Recipe

class RecipeViewModel : ViewModel() {
    private val _recipes = mutableStateListOf<Recipe>()
    val recipes: SnapshotStateList<Recipe> = _recipes

    fun addRecipe(recipe: Recipe) {
        _recipes.add
    }
}