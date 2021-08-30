package com.mohamed.halim.essa.recipe.data.domain


data class Recipe(
    val calories: Double,
    val cuisineType: List<String>,
    val image: String,
    val ingredientLines: List<String>,
    val label: String,
    val mealType: List<String>,
    val shareAs: String,
    val source: String,
    val totalTime: Int,
    val totalWeight: Double,
    val id: String,
    val url: String,
)