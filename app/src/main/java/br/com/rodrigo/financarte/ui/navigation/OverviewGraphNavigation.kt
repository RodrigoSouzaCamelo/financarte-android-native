package br.com.rodrigo.financarte.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.overview.OverviewPage

fun NavGraphBuilder.overviewGraph(navHostController: NavHostController) {
    composable(AppDestination.Overview.screenRoute) {
        OverviewPage(navHostController)
    }
}