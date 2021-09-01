package com.mohamed.halim.essa.recipe.data.network.model


import com.google.gson.annotations.SerializedName


data class Response(
    @SerializedName("count")
    val count: Int,
    @SerializedName("from")
    val from: Int,
    @SerializedName("to")
    val to: Int,
    @SerializedName("hits")
    val recipes: List<RecipeDto>,
    @SerializedName("_links")
    val next: NextLink? = null

)


data class NextLink(
    @SerializedName("next")
    val next: Next
) {
    data class Next(
        @SerializedName("href")
        val href: String,
        @SerializedName("title")
        val title: String
    )
}
