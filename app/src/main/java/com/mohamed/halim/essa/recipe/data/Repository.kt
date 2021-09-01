package com.mohamed.halim.essa.recipe.data

import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.data.local.EntityMapper
import com.mohamed.halim.essa.recipe.data.local.RecipeDao
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.data.network.model.DtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class Repository(private val networkSource: ApiService, private val localSource: RecipeDao) {
    private val dtoMapper = DtoMapper()
    private val entityMapper = EntityMapper()
    fun search(query: String): Flow<List<Recipe>> {
        return flow {
            try {
                val recipes = dtoMapper.mapListToDomain(networkSource.search(query).recipes)
                localSource.deleteAll()
                localSource.insertList(entityMapper.mapListFromDomain(recipes))
            } catch (e : Exception){
            }
            localSource.getAll().collect {
                emit(entityMapper.mapListToDomain(it))
            }
        }
    }
}