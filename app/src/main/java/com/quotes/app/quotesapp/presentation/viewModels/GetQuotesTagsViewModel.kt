package com.quotes.app.quotesapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.app.quotesapp.domain.models.Tag
import com.quotes.app.quotesapp.domain.use_cases.GetQuotesTagsUseCase
import com.quotes.app.quotesapp.utils.Constants
import com.quotes.app.quotesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GetQuotesTagsViewModel @Inject constructor(private val getQuotesTagsUseCase: GetQuotesTagsUseCase) : ViewModel() {
    private val _state = MutableStateFlow(QuotesTagState())
    val state = _state.asStateFlow()

    init {
        getQuotesTags()
    }


    private fun getQuotesTags() {
        getQuotesTagsUseCase().onEach { results ->
            when(results){
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            errorMessage = results.errorMessage ?: "Unexpected error occurred"
                        )
                    }
                }
                is Resource.Loading -> {
                    _state.update {
                        it.copy(
                            isLoading = results.isLoading
                        )
                    }

                }
                is Resource.Success -> {
                    val tagsToMutate : MutableList<Tag> = results.data as MutableList<Tag>
                    tagsToMutate.sortByDescending {
                        it.quotesCount
                    }
                    val tag = Tag("Random","random", Constants.QUOTES_LIMIT)
                    tagsToMutate.add(0,tag)
                    _state.update {
                        it.copy(
                            tags = tagsToMutate
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}