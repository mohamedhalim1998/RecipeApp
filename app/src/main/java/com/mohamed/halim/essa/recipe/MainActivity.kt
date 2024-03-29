package com.mohamed.halim.essa.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.mohamed.halim.essa.recipe.ui.recipedetail.RecipeDetails
import com.mohamed.halim.essa.recipe.ui.theme.RecipeTheme
import com.mohamed.halim.essa.recipe.ui.recipeslistscreen.RecipesScreen
import com.mohamed.halim.essa.recipe.ui.recipeslistscreen.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //val viewModel: RecipesViewModel by viewModel()
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "RECIPES_LIST") {
                    composable("RECIPES_LIST") { RecipesScreen(navController) }
                    composable(
                        "RECIPE_DETAILS?recipe={recipe}",
                        arguments = listOf(navArgument("recipe") {
                            type = NavType.StringType
                        })
                    ) { backStackEntry -> RecipeDetails(backStackEntry.arguments?.getString("recipe")!!) }
                }

            }
        }

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