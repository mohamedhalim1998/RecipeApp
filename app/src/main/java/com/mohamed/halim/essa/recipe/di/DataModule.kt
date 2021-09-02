package com.mohamed.halim.essa.recipe.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.mohamed.halim.essa.recipe.data.Repository
import com.mohamed.halim.essa.recipe.data.local.RecipeDao
import com.mohamed.halim.essa.recipe.data.local.RecipeDatabase
import com.mohamed.halim.essa.recipe.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideNetworkSource(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.edamam.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RecipeDao {
        val db = Room.databaseBuilder(
            context,
            RecipeDatabase::class.java, "database-name"
        ).build()
        return db.recipeDao();
    }

    @Singleton
    @Provides
    fun provideRepository(apiService: ApiService, recipeDao: RecipeDao): Repository {
        return Repository(apiService, recipeDao);
    }
}