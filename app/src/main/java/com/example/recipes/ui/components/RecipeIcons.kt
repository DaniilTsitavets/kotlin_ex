package com.example.recipes.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.RamenDining
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.recipes.data.RecipeType

fun recipeTypeIcon(type: RecipeType): ImageVector = when (type) {
    RecipeType.MAIN -> Icons.Filled.Restaurant
    RecipeType.SOUP -> Icons.Filled.RamenDining
    RecipeType.SALAD -> Icons.Filled.Eco
    RecipeType.BREAKFAST -> Icons.Filled.BakeryDining
    RecipeType.DRINK -> Icons.Filled.LocalCafe
    RecipeType.DESSERT -> Icons.Filled.Cake
}
