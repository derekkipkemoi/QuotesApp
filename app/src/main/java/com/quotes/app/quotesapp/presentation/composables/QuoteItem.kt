package com.quotes.app.quotesapp.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.quotes.app.quotesapp.domain.models.Quote

@Composable
fun QuoteItem(quote: Quote) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = quote.content,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(0.6.dp)
                .background(color = Color.White)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.End
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.author),
//                contentDescription = "Author",
//                modifier = Modifier
//                    .padding(end = 10.dp)
//                    .width(18.dp)
//                    .height(18.dp)
//            )
            Text(
                text = quote.author,
                color = Color.White,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}