package com.mohamed.halim.essa.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.ui.theme.RecipeTheme
import com.mohamed.halim.essa.recipe.ui.recipeslistscreen.RecipesScreen
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                RecipesScreen()
            }
        }

    }

}

fun getRes(res : MutableState<String>) {
    val applicationScope = CoroutineScope(Dispatchers.Default)
    val api = Retrofit.Builder()
        .baseUrl("https://api.edamam.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(ApiService::class.java)
    applicationScope.launch {
        res.value = api.search("egg").toString();
    }


}

@Composable
fun App(content: @Composable () -> Unit) {


    RecipeTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App {
//        Greeting(name = "Recipe")
        //RecipesScreen()
    }
}