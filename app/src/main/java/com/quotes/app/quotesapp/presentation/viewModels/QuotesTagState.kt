package com.quotes.app.quotesapp.presentation.viewModels

import com.quotes.app.quotesapp.domain.models.Tag

data class QuotesTagState(
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val tags: List<Tag>? = null
)
