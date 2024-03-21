package br.com.rodrigo.financarte.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.more.MorePage

fun NavGraphBuilder.moreGraph(navHostController: NavHostController) {
    composable(AppDestination.More.screenRoute) {
        MorePage(navHostController)
    }
}