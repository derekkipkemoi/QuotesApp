package com.quotes.app.quotesapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.app.quotesapp.domain.use_cases.GetQuotesUseCase
import com.quotes.app.quotesapp.presentation.events.QuotesAppEvents
import com.quotes.app.quotesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GetQuotesViewModel @Inject constructor(private val getQuotesUseCase: GetQuotesUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(GetQuotesViewModelState())
    val state = _state.asStateFlow()

    init {
        getQuotes(_state.value.tagSlug)
    }

    fun onEvents(event: QuotesAppEvents){
        when(event){
            is QuotesAppEvents.GetQuotesByTagEvent -> {
                _state.update {
                    it.copy(
                       tagSlug = event.tagSlug
                    )
                }
                getQuotes(_state.value.tagSlug)
            }
        }
    }

    private fun getQuotes(tagSlug: String) {
        getQuotesUseCase(tagSlug).onEach { results ->
            when (results) {
                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = results.isLoading
                        )
                    }
                }

                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            quotes = results.data
                        )
                    }
                }

                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            errorMessage = results.errorMessage ?: "Unexpected error occurred"
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}