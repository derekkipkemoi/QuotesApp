package com.quotes.app.quotesapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quotes.app.quotesapp.presentation.screens.screensContent.Tags
import com.quotes.app.quotesapp.presentation.screens.screensContent.Quotes

@Composable
fun QuotesScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
    ) {
        Tags()
        Quotes()
    }
}