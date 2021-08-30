package com.mohamed.halim.essa.recipe.data

import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.data.network.model.DtoMapper

class Repository(private val networkSource: ApiService) {
    private val mapper = DtoMapper();
    suspend fun search(query: String): List<Recipe> {
        return mapper.mapListToDomain(networkSource.search(query).recipes);
    }
}