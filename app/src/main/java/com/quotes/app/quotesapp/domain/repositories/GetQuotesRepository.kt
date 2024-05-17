package com.quotes.app.quotesapp.domain.repositories

import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItem
import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItemByTag
import com.quotes.app.quotesapp.data.remote.dtos.TagsDTOItem

interface GetQuotesRepository {
    suspend fun getQuotes(limit : Int) : List<QuotesDTOItem>

    suspend fun getQuotesByTag(tag: String) : QuotesDTOItemByTag

    suspend fun getQuotesTags() : List<TagsDTOItem>
}