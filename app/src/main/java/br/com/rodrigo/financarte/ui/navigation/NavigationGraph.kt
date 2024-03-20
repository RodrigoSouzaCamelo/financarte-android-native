package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.OverviewPage

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home.screenRoute,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        homeGraph(navController)
        composable(AppDestination.Overview.screenRoute) {
            OverviewPage()
        }
        transactionGraph(navController)
    }
}