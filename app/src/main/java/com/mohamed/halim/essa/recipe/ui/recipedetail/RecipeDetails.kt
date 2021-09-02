package com.mohamed.halim.essa.recipe.ui.recipedetail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.google.gson.Gson
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.ui.component.ExpandableCard

@ExperimentalMaterialApi
@Composable
fun RecipeDetails(recipeId: String, viewModel: RecipeDetailsViewModel = hiltViewModel()) {
    Log.e(RecipeDetailsViewModel::class.java.name, "reipeid: $recipeId")
    val recipe = viewModel.getRecipe(recipeId).observeAsState()
    val scrollState = ScrollState(0)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = rememberImagePainter(recipe.value?.image),
            contentDescription = recipe.value?.label,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillWidth
        )
        ExpandableCard(title = "Ingredients") {
            recipe.value?.ingredientLines?.forEach {
                Text(
                    it, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
        ExpandableCard(title = "Meal") {
            recipe.value?.mealType?.forEach {
                Text(
                    it, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
        ExpandableCard(title = "Cuisine") {
            recipe.value?.cuisineType?.forEach {
                Text(
                    it, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
        ExpandableCard(title = "Calories") {
            recipe.value?.calories?.apply {
                Text(
                    "%.2f kCal".format(this), modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }
    }
}