package com.example.assignment_3.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.assignment_3.data.MockData
import com.example.assignment_3.models.Recipe

class RecipeViewModel : ViewModel() {
    private val _recipes = mutableStateListOf<Recipe>()
    val recipes: SnapshotStateList<Recipe> = _recipes

    init {
        _recipes.addAll(MockData.recipes)
    }

    fun addRecipe(recipe: Recipe) {
        _recipes.add(recipe)
    }

    fun removeRecipe(recipe: Recipe) {
        _recipes.remove(recipe)
    }

    fun getRecipeByName(name: String): Recipe? {
        return _recipes.find { it.name == name }
    }
}