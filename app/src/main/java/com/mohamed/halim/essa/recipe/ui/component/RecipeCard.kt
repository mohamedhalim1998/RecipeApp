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
import coil.compose.rememberImagePainter

@Composable
fun RecipeCard(imageUrl: String, name: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

            },
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(text = name, modifier = Modifier.fillMaxWidth())
        }

    }
}