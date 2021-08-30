package com.mohamed.halim.essa.recipe.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeDto(
    @Json(name = "recipe")
    val recipeInfo: RecipeInfo
) {

    @JsonClass(generateAdapter = true)
    data class RecipeInfo(
        @Json(name = "calories")
        val calories: Double,
        @Json(name = "cuisineType")
        val cuisineType: List<String>,
        @Json(name = "image")
        val image: String,
        @Json(name = "ingredientLines")
        val ingredientLines: List<String>,
        @Json(name = "label")
        val label: String,
        @Json(name = "mealType")
        val mealType: List<String>,
        @Json(name = "shareAs")
        val shareAs: String,
        @Json(name = "source")
        val source: String,
        @Json(name = "totalTime")
        val totalTime: Int,
        @Json(name = "totalWeight")
        val totalWeight: Double,
        @Json(name = "uri")
        val uri: String,
        @Json(name = "url")
        val url: String,

    )
}
