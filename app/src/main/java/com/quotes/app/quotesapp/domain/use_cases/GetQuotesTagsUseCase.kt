package com.quotes.app.quotesapp.domain.use_cases

import com.quotes.app.quotesapp.data.remote.dtos.toTag
import com.quotes.app.quotesapp.domain.models.Tag
import com.quotes.app.quotesapp.domain.repositories.GetQuotesRepository
import com.quotes.app.quotesapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetQuotesTagsUseCase @Inject constructor(private val getQuotesRepository: GetQuotesRepository) {
    operator fun invoke() : Flow<Resource<List<Tag>>> = flow {
        try {
            emit(Resource.Loading(true))
            val tags = getQuotesRepository.getQuotesTags().map {
                it.toTag()
            }
            emit(Resource.Loading(false))
            emit(Resource.Success(tags))
        }
        catch (e : HttpException){
            emit(Resource.Loading(false))
            emit(Resource.Error("Unexpected error occurred"))
        }

        catch (e: IOException){
            emit(Resource.Loading(false))
            emit(Resource.Error("Please check your internet connection"))
        }
    }
}