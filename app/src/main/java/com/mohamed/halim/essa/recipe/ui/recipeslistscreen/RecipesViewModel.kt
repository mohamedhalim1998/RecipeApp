package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.lifecycle.*
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import androidx.hilt.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val repository: Repository,
    private val state: SavedStateHandle,
) : ViewModel() {
    private val _query = MutableLiveData<String>()
    val query: LiveData<String>
        get() = _query


    private val _recipes = MutableLiveData<List<Recipe>>();
    val recipes: LiveData<List<Recipe>>
        get() = _recipes

    init {
        _query.value = "egg"
        search()
    }

    fun search() {
        viewModelScope.launch {
            repository.search(query.value!!).collect { recipes ->
                _recipes.value = recipes
            }
        }
    }

    fun changeQuery(query: String) {
        _query.value = query;
    }

    fun setRecipeNavId(recipeId: String) {
        state["STATE_KEY_RECIPE"] = recipeId
    }


}
