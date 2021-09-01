package com.mohamed.halim.essa.recipe.data.network.model

import com.google.gson.annotations.SerializedName


data class RecipeDto(
    @SerializedName("recipe")
    val recipeInfo: RecipeInfo
) {

    data class RecipeInfo(
        @SerializedName("calories")
        val calories: Double,
        @SerializedName("cuisineType")
        val cuisineType: List<String>,
        @SerializedName("image")
        val image: String,
        @SerializedName("ingredientLines")
        val ingredientLines: List<String>,
        @SerializedName("label")
        val label: String,
        @SerializedName("mealType")
        val mealType: List<String>,
        @SerializedName("shareAs")
        val shareAs: String,
        @SerializedName("source")
        val source: String,
        @SerializedName("totalTime")
        val totalTime: Int,
        @SerializedName("totalWeight")
        val totalWeight: Double,
        @SerializedName("uri")
        val uri: String,
        @SerializedName("url")
        val url: String,

    )
}
