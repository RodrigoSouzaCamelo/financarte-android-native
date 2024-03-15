package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.HomePage
import br.com.rodrigo.financarte.ui.pages.OverviewPage
import br.com.rodrigo.financarte.ui.pages.TransactionsPage

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.screenRoute,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        composable(BottomNavItem.Home.screenRoute) {
            HomePage()
        }
        composable(BottomNavItem.Overview.screenRoute) {
            OverviewPage()
        }
        composable(BottomNavItem.Transactions.screenRoute) {
            TransactionsPage()
        }
    }
}