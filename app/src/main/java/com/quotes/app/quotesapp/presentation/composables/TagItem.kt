package com.quotes.app.quotesapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.quotes.app.quotesapp.domain.models.Tag
import com.quotes.app.quotesapp.presentation.events.QuotesAppEvents

@Composable
fun TagItem(
    tag: Tag, currentSelectedTag: String, onEvent: (QuotesAppEvents) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(10.dp, top = 3.dp, bottom = 3.dp)
            .height(50.dp)
            .border(
                width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = when (tag.slug) {
                    currentSelectedTag -> Color.Black
                    else -> {
                        Color.White
                    }
                }, shape = RoundedCornerShape(10.dp)

            )
            .clickable {
                onEvent(QuotesAppEvents.GetQuotesByTagEvent(tag.slug))
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = tag.name,
            modifier = Modifier.padding(20.dp, end = 20.dp),
            color = when (tag.slug) {
                currentSelectedTag -> Color.White
                else -> {
                    Color.Black
                }
            },
        )
    }
}