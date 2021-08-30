package com.mohamed.halim.essa.recipe.data.network.model

import com.mohamed.halim.essa.recipe.data.domain.DomainMapper
import com.mohamed.halim.essa.recipe.data.domain.Recipe

class DtoMapper : DomainMapper<RecipeDto> {
    override fun mapFromDomain(recipe: Recipe): RecipeDto {
        return RecipeDto(
            RecipeDto.RecipeInfo(
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
                "http://www.edamam.com/ontologies/edamam.owl#${recipe.id}",
                recipe.url,
            )
        );
    }

    override fun mapToDomain(model: RecipeDto): Recipe {
        return Recipe(
            model.recipeInfo.calories,
            model.recipeInfo.cuisineType,
            model.recipeInfo.image,
            model.recipeInfo.ingredientLines,
            model.recipeInfo.label,
            model.recipeInfo.mealType,
            model.recipeInfo.shareAs,
            model.recipeInfo.source,
            model.recipeInfo.totalTime,
            model.recipeInfo.totalWeight,
            model.recipeInfo.uri.split("#")[1],
            model.recipeInfo.url,
        )
    }

    fun mapListToDomain(recipes: List<RecipeDto>): List<Recipe> {
        return recipes.map { recipe -> mapToDomain(recipe) }
    }
    fun mapListFromDomain(recipes: List<Recipe>): List<RecipeDto> {
        return recipes.map { recipe -> mapFromDomain(recipe) }
    }


}