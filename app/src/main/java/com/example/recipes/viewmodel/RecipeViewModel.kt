package com.example.recipes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.Recipe
import com.example.recipes.data.RecipeRepository
import com.example.recipes.data.RecipeType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    val recipes: StateFlow<List<Recipe>> = repository.allRecipes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    private val _uiState = MutableStateFlow(RecipeFormState())
    val uiState: StateFlow<RecipeFormState> = _uiState.asStateFlow()

    private var editingId: Int? = null

    fun onTitleChange(value: String) {
        _uiState.update { it.copy(title = value, titleError = false) }
    }

    fun onTypeChange(value: RecipeType) {
        _uiState.update { it.copy(type = value) }
    }

    fun onIngredientsChange(value: String) {
        _uiState.update { it.copy(ingredients = value) }
    }

    fun onInstructionsChange(value: String) {
        _uiState.update { it.copy(instructions = value) }
    }

    fun onCookingTimeChange(value: String) {
        if (value.all { it.isDigit() }) {
            _uiState.update { it.copy(cookingTime = value) }
        }
    }

    fun onServingsChange(value: String) {
        if (value.all { it.isDigit() }) {
            _uiState.update { it.copy(servings = value) }
        }
    }

    fun prepareNewRecipe() {
        editingId = null
        _uiState.value = RecipeFormState(isEditing = false)
    }

    fun prepareEditRecipe(recipe: Recipe) {
        editingId = recipe.id
        _uiState.value = RecipeFormState(
            title = recipe.title,
            type = recipe.type,
            ingredients = recipe.ingredients,
            instructions = recipe.instructions,
            cookingTime = recipe.cookingTimeMinutes.toString(),
            servings = recipe.servings.toString(),
            isEditing = true
        )
    }

    fun saveRecipe(): Boolean {
        val state = _uiState.value
        if (state.title.isBlank()) {
            _uiState.update { it.copy(titleError = true) }
            return false
        }

        val recipe = Recipe(
            id = editingId ?: 0,
            title = state.title.trim(),
            type = state.type,
            ingredients = state.ingredients.trim(),
            instructions = state.instructions.trim(),
            cookingTimeMinutes = state.cookingTime.toIntOrNull() ?: 0,
            servings = state.servings.toIntOrNull() ?: 0
        )

        viewModelScope.launch {
            if (editingId == null) {
                repository.insert(recipe)
            } else {
                repository.update(recipe)
            }
        }
        return true
    }

    fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch {
            repository.delete(recipe)
        }
    }
}
