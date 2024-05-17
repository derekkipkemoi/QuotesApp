package com.quotes.app.quotesapp.presentation.viewModels

import com.quotes.app.quotesapp.domain.models.Quote

data class GetQuotesViewModelState(
    val quotes: List<Quote>? = null,
    val errorMessage: String = "",
    val tagSlug: String = "random",
    val isLoading: Boolean = false
)
