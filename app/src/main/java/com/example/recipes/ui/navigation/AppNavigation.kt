package com.example.recipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipes.ui.screens.RecipeDetailScreen
import com.example.recipes.ui.screens.RecipeEditScreen
import com.example.recipes.ui.screens.RecipeListScreen
import com.example.recipes.viewmodel.RecipeViewModel

object Routes {
    const val LIST = "list"
    const val DETAIL = "detail/{recipeId}"
    const val EDIT = "edit"

    fun detail(recipeId: Int) = "detail/$recipeId"
}

@Composable
fun AppNavigation(viewModel: RecipeViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LIST) {

        composable(Routes.LIST) {
            RecipeListScreen(
                viewModel = viewModel,
                onRecipeClick = { id -> navController.navigate(Routes.detail(id)) },
                onAddClick = {
                    viewModel.prepareNewRecipe()
                    navController.navigate(Routes.EDIT)
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("recipeId") ?: 0
            RecipeDetailScreen(
                recipeId = id,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onEdit = { recipe ->
                    viewModel.prepareEditRecipe(recipe)
                    navController.navigate(Routes.EDIT)
                },
                onDeleted = { navController.popBackStack() }
            )
        }

        composable(Routes.EDIT) {
            RecipeEditScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onSaved = { navController.popBackStack() }
            )
        }
    }
}
