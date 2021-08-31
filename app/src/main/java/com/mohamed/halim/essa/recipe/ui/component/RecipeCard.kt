package com.mohamed.halim.essa.recipe.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Composable
fun RecipeCard(recipe: Recipe, navController: NavController) {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(Recipe::class.java)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("RECIPE_DETAILS?recipe=${jsonAdapter.toJson(recipe)}")
            },
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = rememberImagePainter(recipe.image),
                contentDescription = recipe.label,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(text = recipe.label, modifier = Modifier.fillMaxWidth())
        }

    }
}