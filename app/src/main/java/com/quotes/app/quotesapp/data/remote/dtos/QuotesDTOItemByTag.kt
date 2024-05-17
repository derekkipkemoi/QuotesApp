package com.quotes.app.quotesapp.data.remote.dtos


import com.squareup.moshi.Json

data class QuotesDTOItemByTag(
    @Json(name = "count")
    val count: Int,
    @Json(name = "lastItemIndex")
    val lastItemIndex: Any,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<QuotesDTOItem>,
    @Json(name = "totalCount")
    val totalCount: Int,
    @Json(name = "totalPages")
    val totalPages: Int
)


