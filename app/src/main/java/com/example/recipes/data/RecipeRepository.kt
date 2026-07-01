package com.example.recipes.data

import kotlinx.coroutines.flow.Flow

class RecipeRepository(private val recipeDao: RecipeDao) {

    val allRecipes: Flow<List<Recipe>> = recipeDao.getAllRecipes()

    fun getRecipeById(id: Int): Flow<Recipe?> = recipeDao.getRecipeById(id)

    suspend fun insert(recipe: Recipe) = recipeDao.insert(recipe)

    suspend fun update(recipe: Recipe) = recipeDao.update(recipe)

    suspend fun delete(recipe: Recipe) = recipeDao.delete(recipe)
}
