package com.example.recipes.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromRecipeType(type: RecipeType): String = type.name

    @TypeConverter
    fun toRecipeType(value: String): RecipeType = RecipeType.valueOf(value)
}
