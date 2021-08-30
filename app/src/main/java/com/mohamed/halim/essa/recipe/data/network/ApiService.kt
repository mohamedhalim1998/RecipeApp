package com.mohamed.halim.essa.recipe.data.network

import com.mohamed.halim.essa.recipe.data.network.model.Response
import com.mohamed.halim.essa.recipe.util.APP_ID
import com.mohamed.halim.essa.recipe.util.APP_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("recipes/v2/?type=public&app_id=$APP_ID&app_key=$APP_KEY")
    suspend fun search(
        @Query("q") query: String
    ): Response

}