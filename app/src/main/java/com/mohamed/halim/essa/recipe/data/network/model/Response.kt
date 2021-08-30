package com.mohamed.halim.essa.recipe.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "count")
    val count: Int,
    @Json(name = "from")
    val from: Int,
    @Json(name = "to")
    val to: Int,
    @Json(name = "hits")
    val recipes: List<RecipeDto>,
    @Json(name = "_links")
    val next: NextLink

)


@JsonClass(generateAdapter = true)
data class NextLink(
    @Json(name = "next")
    val next: Next
) {
    @JsonClass(generateAdapter = true)
    data class Next(
        @Json(name = "href")
        val href: String,
        @Json(name = "title")
        val title: String
    )
}
