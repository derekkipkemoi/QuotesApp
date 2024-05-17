package com.quotes.app.quotesapp.presentation.navigation

import com.quotes.app.quotesapp.R

sealed class NavigationData(val routeName: String, val routeIcon: Int) {
    data object Quotes : NavigationData("Quotes", R.drawable.quotation)
//    data object Authors: NavigationData("Authors", R.drawable.author)
    data object Search: NavigationData("Search",R.drawable.search)
    data object Favourites: NavigationData("Favourites", R.drawable.favourite)
}