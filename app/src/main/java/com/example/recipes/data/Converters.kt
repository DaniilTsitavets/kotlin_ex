package com.example.recipes.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromRecipeType(type: RecipeType): String = type.name

    @TypeConverter
    fun toRecipeType(value: String): RecipeType = RecipeType.valueOf(value)

    @TypeConverter
    fun fromDifficulty(difficulty: Difficulty): String = difficulty.name

    @TypeConverter
    fun toDifficulty(value: String): Difficulty = Difficulty.valueOf(value)
}
