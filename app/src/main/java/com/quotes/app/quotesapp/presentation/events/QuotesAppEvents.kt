package com.quotes.app.quotesapp.presentation.events

sealed interface QuotesAppEvents {
    class GetQuotesByTagEvent(val tagSlug: String) : QuotesAppEvents
}