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
import com.google.gson.Gson
import com.mohamed.halim.essa.recipe.data.domain.Recipe


@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
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