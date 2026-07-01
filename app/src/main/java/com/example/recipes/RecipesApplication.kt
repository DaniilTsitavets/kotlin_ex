package com.example.recipes

import android.app.Application
import com.example.recipes.data.RecipeDatabase
import com.example.recipes.data.RecipeRepository

class RecipesApplication : Application() {

    private val database by lazy { RecipeDatabase.getDatabase(this) }

    val repository by lazy { RecipeRepository(database.recipeDao()) }
}
