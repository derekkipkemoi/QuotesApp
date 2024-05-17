package com.quotes.app.quotesapp.data.remote

import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItemByTag
import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItem
import com.quotes.app.quotesapp.data.remote.dtos.TagsDTOItem
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {
    @GET("/quotes/random")
    suspend fun getQuotes(@Query("limit") limit: Int) : List<QuotesDTOItem>

    @GET("/quotes")
    suspend fun getQuotesByTag(@Query("tags") tag: String) : QuotesDTOItemByTag

    @GET("/tags")
    suspend fun getQuotesTags() : List<TagsDTOItem>
}