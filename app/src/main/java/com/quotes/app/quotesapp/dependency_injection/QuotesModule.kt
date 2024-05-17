package com.quotes.app.quotesapp.dependency_injection

import com.quotes.app.quotesapp.data.remote.QuotesAPI
import com.quotes.app.quotesapp.data.remote.repositoriesImp.GetQuotesRepositoryImp
import com.quotes.app.quotesapp.domain.repositories.GetQuotesRepository
import com.quotes.app.quotesapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuotesModule {

    @Provides
    @Singleton
    fun providesQuotesApi(): QuotesAPI = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()).build().create(QuotesAPI::class.java)


    @Provides
    @Singleton
    fun providesGetQuotesRepository(quotesAPI: QuotesAPI): GetQuotesRepository =
        GetQuotesRepositoryImp(quotesAPI)
}