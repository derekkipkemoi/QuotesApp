package com.quotes.app.quotesapp.domain.models

data class Quote(
    val author: String,
    val authorSlug: String,
    val content: String,
    val tags: List<String>,
    var liked: Boolean = false
)
