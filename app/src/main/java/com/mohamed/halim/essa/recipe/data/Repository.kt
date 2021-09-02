package com.mohamed.halim.essa.recipe.data

import android.util.Log
import com.mohamed.halim.essa.recipe.data.domain.Recipe
import com.mohamed.halim.essa.recipe.data.local.EntityMapper
import com.mohamed.halim.essa.recipe.data.local.RecipeDao
import com.mohamed.halim.essa.recipe.data.network.ApiService
import com.mohamed.halim.essa.recipe.data.network.model.DtoMapper
import com.mohamed.halim.essa.recipe.ui.recipedetail.RecipeDetailsViewModel
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
            } catch (e: Exception) {
            }
            localSource.getAll().collect {
                emit(entityMapper.mapListToDomain(it))
            }
        }
    }

    fun getRecipe(id: String): Flow<Recipe> {
        Log.e(Repository::class.java.name, "reipeid: $id")

        return flow {
             localSource.getById(id).collect {
                 Log.e("DAO", "reipeid: $id")
                 emit(entityMapper.mapToDomain(it))
            }
        }
    }
}