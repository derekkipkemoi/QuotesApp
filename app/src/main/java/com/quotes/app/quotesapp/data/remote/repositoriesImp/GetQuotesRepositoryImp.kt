package com.quotes.app.quotesapp.data.remote.repositoriesImp

import com.quotes.app.quotesapp.data.remote.QuotesAPI
import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItemByTag
import com.quotes.app.quotesapp.data.remote.dtos.QuotesDTOItem
import com.quotes.app.quotesapp.data.remote.dtos.TagsDTOItem
import com.quotes.app.quotesapp.domain.repositories.GetQuotesRepository
import javax.inject.Inject

class GetQuotesRepositoryImp @Inject constructor(private val quotesAPI: QuotesAPI) :
    GetQuotesRepository {
    override suspend fun getQuotes(limit: Int): List<QuotesDTOItem> = quotesAPI.getQuotes(limit)

    override suspend fun getQuotesByTag(tag: String): QuotesDTOItemByTag =
        quotesAPI.getQuotesByTag(tag)

    override suspend fun getQuotesTags(): List<TagsDTOItem> = quotesAPI.getQuotesTags()

}