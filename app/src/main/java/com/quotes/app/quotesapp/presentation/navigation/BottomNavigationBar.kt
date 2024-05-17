package com.quotes.app.quotesapp.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val bottomBarItems = listOf(
        NavigationData.Quotes,
        NavigationData.Search,
        NavigationData.Favourites
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        bottomBarItems.forEach { navigationItem ->
            NavigationBarItem(selected = navigationItem.routeName == currentRoute, onClick = {
                navController.navigate(navigationItem.routeName) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = {
                Image(
                    painter = painterResource(id = navigationItem.routeIcon),
                    contentDescription = navigationItem.routeName,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }, label = {
                Text(text = navigationItem.routeName)
            })

        }
    }
}