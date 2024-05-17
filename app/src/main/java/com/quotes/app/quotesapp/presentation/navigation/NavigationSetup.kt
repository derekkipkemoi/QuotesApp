package com.quotes.app.quotesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quotes.app.quotesapp.presentation.screens.Favourites
import com.quotes.app.quotesapp.presentation.screens.QuotesScreen
import com.quotes.app.quotesapp.presentation.screens.Search

@Composable
fun NavigationSetup(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationData.Quotes.routeName
    ) {
        composable(route = NavigationData.Quotes.routeName) {
            QuotesScreen()
        }
//        composable(route = NavigationData.Authors.routeName) {
//            Authors()
//        }
        composable(route = NavigationData.Search.routeName) {
            Search()
        }
        composable(route = NavigationData.Favourites.routeName) {
            Favourites()
        }
    }

}