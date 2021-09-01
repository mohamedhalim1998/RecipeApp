package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.local.RecipeDatabase
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.ui.component.RecipeCard
import com.mohamed.halim.essa.recipe.ui.component.SearchBar

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@ExperimentalComposeUiApi
@Composable
fun RecipesScreen(navController: NavController) {
    val viewModel = initViewModel()
    val recipes = viewModel.recipes.observeAsState(listOf())
    val query = viewModel.query.observeAsState("")

    Scaffold(
        topBar = {
            SearchBar(viewModel = viewModel, query = query)
        }
    ) {
        LazyColumn {
            items(recipes.value) { recipe ->
                RecipeCard(recipe = recipe, navController)
            }
        }
    }
}

@Composable
fun initViewModel(): RecipesViewModel {
    val api = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/api/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(ApiService::class.java)
    val db = Room.databaseBuilder(
        LocalContext.current,
        RecipeDatabase::class.java, "database-name"
    ).build()

    val repo = Repository(api, db.recipeDao())
    val factory = RecipesViewModelFactory(repo);
    return viewModel(
        factory = factory
    );
}



