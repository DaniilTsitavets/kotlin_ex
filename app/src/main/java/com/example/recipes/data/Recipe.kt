package com.example.recipes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class RecipeType(val displayName: String) {
    MAIN("Основное блюдо"),
    DESSERT("Десерт")
}

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val type: RecipeType,
    val ingredients: String,
    val instructions: String,
    val cookingTimeMinutes: Int,
    val servings: Int
)
