package com.example.recipes.viewmodel

import com.example.recipes.data.Difficulty
import com.example.recipes.data.RecipeType

data class RecipeFormState(
    val title: String = "",
    val type: RecipeType = RecipeType.MAIN,
    val difficulty: Difficulty = Difficulty.EASY,
    val ingredients: String = "",
    val instructions: String = "",
    val cookingTime: String = "",
    val servings: String = "",
    val isEditing: Boolean = false,
    val titleError: Boolean = false
)
