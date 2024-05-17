package com.quotes.app.quotesapp.presentation.screens.screensContent

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.quotes.app.quotesapp.presentation.composables.TagItem
import com.quotes.app.quotesapp.presentation.viewModels.GetQuotesTagsViewModel
import com.quotes.app.quotesapp.presentation.viewModels.GetQuotesViewModel

@Composable
fun Tags(
    getQuotesTagsViewModel: GetQuotesTagsViewModel = hiltViewModel(),
    getQuotesViewModel: GetQuotesViewModel = hiltViewModel()
){
    val state by getQuotesTagsViewModel.state.collectAsState()
    val quotesState by getQuotesViewModel.state.collectAsState()
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            state.tags?.let {
                it.forEach { tag ->
                    TagItem(
                        tag,
                        currentSelectedTag = quotesState.tagSlug,
                        onEvent = getQuotesViewModel::onEvents
                    )
                }
            }
        }
        if (state.errorMessage.isNotEmpty()) {
            Text(text = state.errorMessage)
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}