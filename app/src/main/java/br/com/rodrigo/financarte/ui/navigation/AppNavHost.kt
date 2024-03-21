package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.overview.OverviewPage

@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.screenRoute,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        homeGraph(navController)
        moreGraph(navController)
        overviewGraph(navController)
        transactionGraph(navController)
    }
}

fun NavHostController.navigateTo(route: String) = this.navigate(route) {
    graph.startDestinationRoute?.let { screenRoute ->
        popUpTo(screenRoute) {
            saveState = true
        }
    }
    launchSingleTop = true
    restoreState = true
}