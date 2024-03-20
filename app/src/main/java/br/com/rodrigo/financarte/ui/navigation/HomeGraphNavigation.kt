package br.com.rodrigo.financarte.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.home.HomePage

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    composable(AppDestination.Home.screenRoute) {
        HomePage(navController)
    }
}