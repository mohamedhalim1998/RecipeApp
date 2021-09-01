package com.mohamed.halim.essa.recipe.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohamed.halim.essa.recipe.util.RoomConverter

@Database(entities = [RecipeEntity::class], version = 1)
@TypeConverters(RoomConverter::class)

abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
