package com.quotes.app.quotesapp.presentation.screens.screensContent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quotes.app.quotesapp.presentation.composables.QuoteItem
import com.quotes.app.quotesapp.presentation.viewModels.GetQuotesViewModel

@Composable
fun Quotes(
    getQuotesViewModel: GetQuotesViewModel = hiltViewModel(),
){
    val state by getQuotesViewModel.state.collectAsState()
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            state.quotes?.let { quotesList ->
                items(count = quotesList.size) { item ->
                    QuoteItem(quote = quotesList[item])
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