package com.quotes.app.quotesapp.data.remote.dtos


import com.quotes.app.quotesapp.domain.models.Tag
import com.squareup.moshi.Json

data class TagsDTOItem(
    @Json(name = "dateAdded") val dateAdded: String,
    @Json(name = "dateModified") val dateModified: String,
    @Json(name = "_id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "quoteCount") val quoteCount: Int,
    @Json(name = "slug") val slug: String
)

fun TagsDTOItem.toTag(): Tag = Tag(
    name = name, quotesCount = quoteCount, slug = slug
)