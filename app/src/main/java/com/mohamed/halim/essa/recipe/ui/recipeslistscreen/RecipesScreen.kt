package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.lifecycle.viewmodel.compose.viewModel
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.ui.component.RecipeCard
import com.mohamed.halim.essa.recipe.ui.component.SearchBar
import com.squareup.moshi.Moshi

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@ExperimentalComposeUiApi
@Composable
fun RecipesScreen() {
    val viewModel = initViewModel()
    val recipes = viewModel.recipes.observeAsState(listOf())
    val query = viewModel.query.observeAsState("")

    Scaffold(
        topBar = {
            SearchBar(viewModel = viewModel, query = query)
        }
    ) {
        LazyColumn {
            itemsIndexed(recipes.value) { index, recipe ->
                RecipeCard(imageUrl = recipe.image, name = recipe.label)
            }
        }
    }
}

@Composable
fun initViewModel(): RecipesViewModel {
    val api = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(ApiService::class.java)
    val repo = Repository(api)
    val factory = RecipesViewModelFactory(repo);
    return viewModel(
        factory = factory
    );
}



