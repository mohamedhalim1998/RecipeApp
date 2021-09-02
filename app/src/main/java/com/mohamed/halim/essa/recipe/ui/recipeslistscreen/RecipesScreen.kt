package com.mohamed.halim.essa.recipe.ui.recipeslistscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController

import com.mohamed.halim.essa.recipe.ui.component.RecipeCard
import com.mohamed.halim.essa.recipe.ui.component.SearchBar


@ExperimentalComposeUiApi
@Composable
fun RecipesScreen(navController: NavController, viewModel: RecipesViewModel = hiltViewModel()) {

    val recipes = viewModel.recipes.observeAsState(listOf())
    val query = viewModel.query.observeAsState("")

    Scaffold(
        topBar = {
            SearchBar(viewModel = viewModel, query = query)
        }
    ) {
        LazyColumn {
            items(recipes.value) { recipe ->
                RecipeCard(recipe = recipe) {
                    navController.navigate("RECIPE_DETAILS?recipe=${recipe.id}")
                }
            }
        }
    }
}



