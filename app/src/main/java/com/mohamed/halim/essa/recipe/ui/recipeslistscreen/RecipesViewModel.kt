package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import kotlinx.coroutines.Dispatchers

class RecipesViewModel(private val repository: Repository) : ViewModel() {
    val recipes: LiveData<List<Recipe>> = repository.search("egg").asLiveData(Dispatchers.IO);
}

class RecipesViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesViewModel::class.java)) {
            return RecipesViewModel(repository) as T;
        }
        throw IllegalArgumentException()
    }

}