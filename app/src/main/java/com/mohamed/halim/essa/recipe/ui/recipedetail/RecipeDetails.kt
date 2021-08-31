package com.mohamed.halim.essa.recipe.ui.recipedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.ui.component.ExpandableCard
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@ExperimentalMaterialApi
@Composable
fun RecipeDetails(recipeJSON: String) {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(Recipe::class.java).lenient()
    val recipe = jsonAdapter.fromJson(recipeJSON);
    val scrollState = ScrollState(0)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = rememberImagePainter(recipe?.image),
            contentDescription = recipe?.label,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillWidth
        )
        ExpandableCard(title = "Ingredients") {
            recipe?.ingredientLines?.forEach {
                Text(it, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            }
        }
        ExpandableCard(title = "Meal") {
            recipe?.mealType?.forEach {
                Text(it, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            }
        }
        ExpandableCard(title = "Cuisine") {
            recipe?.cuisineType?.forEach {
                Text(it, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            }
        }
        ExpandableCard(title = "Calories") {
            recipe?.calories?.apply {
                Text("%.2f kCal".format(this), modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp))
            }
        }
    }
}