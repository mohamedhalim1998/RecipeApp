package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.lifecycle.*
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipesViewModel(private val repository: Repository) : ViewModel() {
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


}

class RecipesViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
            return RecipesViewModel(repository) as T;
        }
        throw IllegalArgumentException()
    }

}