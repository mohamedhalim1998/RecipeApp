package com.mohamed.halim.essa.recipe.ui.recipedetail

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

const val STATE_KEY_RECIPE = "state-recipe-key"

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val repository: Repository,
    private val state: SavedStateHandle,
) : ViewModel() {
    private val _recipe = MutableLiveData<Recipe>()
    val recipe: LiveData<Recipe>
        get() = _recipe

    fun getRecipe(id: String): LiveData<Recipe> {
        viewModelScope.launch {
            Log.e(RecipeDetailsViewModel::class.java.name, "reipeid: $id")

            repository.getRecipe(id).collect {
                _recipe.value = it
            }
        }
        return recipe;
    }

}