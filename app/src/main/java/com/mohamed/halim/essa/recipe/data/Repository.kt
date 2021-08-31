package com.mohamed.halim.essa.recipe.data

import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.data.network.model.DtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class Repository(private val networkSource: ApiService) {
    private val mapper = DtoMapper();
    fun search(query: String): Flow<List<Recipe>> {
        return flow {
            emit(mapper.mapListToDomain(networkSource.search(query).recipes))
        }
    }
}