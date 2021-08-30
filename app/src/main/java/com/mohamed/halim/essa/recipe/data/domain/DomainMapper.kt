package com.mohamed.halim.essa.recipe.data.domain

interface DomainMapper<T> {
    fun mapFromDomain(recipe: Recipe) : T
    //fun mapFromDomainList() : List<T>
    fun mapToDomain(model : T) : Recipe
    //fun mapToDomainList() : List<Recipe>
}