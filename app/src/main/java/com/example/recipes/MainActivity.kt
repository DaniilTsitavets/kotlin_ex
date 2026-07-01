package com.example.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipes.ui.navigation.AppNavigation
import com.example.recipes.ui.theme.MyRecipesTheme
import com.example.recipes.viewmodel.RecipeViewModel
import com.example.recipes.viewmodel.RecipeViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = (application as RecipesApplication).repository

        setContent {
            MyRecipesTheme {
                val recipeViewModel: RecipeViewModel = viewModel(
                    factory = RecipeViewModelFactory(repository)
                )
                AppNavigation(viewModel = recipeViewModel)
            }
        }
    }
}
