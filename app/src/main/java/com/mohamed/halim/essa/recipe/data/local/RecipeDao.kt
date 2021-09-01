package com.mohamed.halim.essa.recipe.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll() : Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe WHERE id = :id")
    fun getById(id: String) : Flow<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(recipes: List<RecipeEntity>)

    @Delete
    suspend fun delete(recipeEntity: RecipeEntity)

    @Query("DELETE FROM recipe")
    suspend fun deleteAll()
}