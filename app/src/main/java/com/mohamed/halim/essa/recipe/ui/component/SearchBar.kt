package com.mohamed.halim.essa.recipe.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mohamed.halim.essa.recipe.ui.recipeslistscreen.RecipesViewModel

@ExperimentalComposeUiApi
@Composable
fun SearchBar(viewModel: RecipesViewModel, query: State<String>) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = query.value,
        onValueChange = { value ->
            viewModel.changeQuery(value)
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                if (query.value != "") {
                    viewModel.search()
                }
                keyboardController?.hide();

            },
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}