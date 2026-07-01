package com.example.recipes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class RecipeType(val displayName: String) {
    MAIN("Основное блюдо"),
    SOUP("Суп"),
    SALAD("Салат"),
    BREAKFAST("Завтрак"),
    DRINK("Напиток"),
    DESSERT("Десерт")
}

enum class Difficulty(val displayName: String) {
    EASY("Лёгкая"),
    MEDIUM("Средняя"),
    HARD("Сложная")
}

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val type: RecipeType,
    val difficulty: Difficulty = Difficulty.EASY,
    val ingredients: String,
    val instructions: String,
    val cookingTimeMinutes: Int,
    val servings: Int
)
