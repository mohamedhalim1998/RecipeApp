package com.mohamed.halim.essa.recipe.data.local

import com.mohamed.halim.essa.recipe.data.domain.DomainMapper
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.data.network.model.RecipeDto

class EntityMapper : DomainMapper<RecipeEntity> {
    override fun mapFromDomain(recipe: Recipe): RecipeEntity {
        return RecipeEntity(
            recipe.calories,
            recipe.cuisineType,
            recipe.image,
            recipe.ingredientLines,
            recipe.label,
            recipe.mealType,
            recipe.shareAs,
            recipe.source,
            recipe.totalTime,
            recipe.totalWeight,
            recipe.id,
            recipe.url,
        )

    }

    override fun mapToDomain(model: RecipeEntity): Recipe {
       return Recipe(
           model.calories,
           model.cuisineType,
           model.image,
           model.ingredientLines,
           model.label,
           model.mealType,
           model.shareAs,
           model.source,
           model.totalTime,
           model.totalWeight,
           model.id,
           model.url,
       )
    }
    fun mapListToDomain(recipes: List<RecipeEntity>): List<Recipe> {
        return recipes.map { recipe -> mapToDomain(recipe) }
    }
    fun mapListFromDomain(recipes: List<Recipe>): List<RecipeEntity> {
        return recipes.map { recipe -> mapFromDomain(recipe) }
    }
}