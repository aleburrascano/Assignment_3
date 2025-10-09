package com.example.assignment_3.screens.addrecipe

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.assignment_3.R
import com.example.assignment_3.models.Ingredient
import com.example.assignment_3.models.Recipe

/**
 * Save button with form validation for recipe creation.
 *
 * @param recipeName Current recipe name
 * @param ingredients List of current ingredients
 * @param imageUri Selected image URI (can be null)
 * @param onError Callback for validation errors (receives error message)
 * @param onSave Callback when recipe is valid and should be saved (receives Recipe)
 */
@Composable
fun SaveRecipeButton(
    recipeName: String,
    ingredients: List<Ingredient>,
    imageUri: String?,
    onError: (String) -> Unit,
    onSave: (Recipe) -> Unit
) {
    Button(
        onClick = {
            when {
                recipeName.isBlank() -> {
                    onError(context.getString(R.string.please_enter_a_recipe_name))
                }
                recipeName.length < 3 -> {
                    onError(context.getString(R.string.recipe_name_must_be_at_least_3_characters_long))
                }
                ingredients.isEmpty() -> {
                    onError(context.getString(R.string.please_add_at_least_one_ingredient))
                }
                else -> {
                    onSave(
                        Recipe(
                            name = recipeName.trim(),
                            ingredients = ingredients,
                            imageUri = imageUri ?: ""
                        )
                    )
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
            text = stringResource(R.string.save_recipe),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}