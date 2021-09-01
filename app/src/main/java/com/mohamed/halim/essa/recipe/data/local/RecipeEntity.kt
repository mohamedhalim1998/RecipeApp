package com.mohamed.halim.essa.recipe.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeEntity(
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
    @PrimaryKey
    val id: String,
    val url: String,
)