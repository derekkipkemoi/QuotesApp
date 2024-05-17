package com.quotes.app.quotesapp.data.remote.dtos


import com.quotes.app.quotesapp.domain.models.Quote
import com.squareup.moshi.Json

data class QuotesDTOItem(
    @Json(name = "author") val author: String,
    @Json(name = "authorSlug") val authorSlug: String,
    @Json(name = "content") val content: String,
    @Json(name = "dateAdded") val dateAdded: String,
    @Json(name = "dateModified") val dateModified: String,
    @Json(name = "_id") val id: String,
    @Json(name = "length") val length: Int,
    @Json(name = "liked") var liked: Boolean = false,
    @Json(name = "tags") val tags: List<String>
)

fun QuotesDTOItem.toQuote(): Quote = Quote(
    author = author, authorSlug = authorSlug, content = content, tags = tags,
    liked = liked
)
