package com.quotes.app.quotesapp.domain.use_cases

import com.quotes.app.quotesapp.data.remote.dtos.toQuote
import com.quotes.app.quotesapp.domain.models.Quote
import com.quotes.app.quotesapp.domain.repositories.GetQuotesRepository
import com.quotes.app.quotesapp.utils.Constants
import com.quotes.app.quotesapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val getQuotesRepository: GetQuotesRepository) {
    operator fun invoke(tagSlug: String): Flow<Resource<List<Quote>>> = flow {
        try {
            emit(Resource.Loading(true))
            when(tagSlug){
                "random" -> {
                    val quotes = getQuotesRepository.getQuotes(Constants.QUOTES_LIMIT).map {
                        it.toQuote() }
                    emit(Resource.Success(quotes))
                    emit(Resource.Loading(false))
                }
                else -> {
                    val quotes = getQuotesRepository.getQuotesByTag(tagSlug).results.map {
                        it.toQuote()
                    }
                    emit(Resource.Success(quotes))
                    emit(Resource.Loading(false))
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error("Please check your internet connection"))
            emit(Resource.Loading(false))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
            emit(Resource.Loading(false))
        }
    }
}