package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.financarte.ui.pages.transaction.add.TransactionAddPage
import br.com.rodrigo.financarte.ui.pages.transaction.list.TransactionListPage

fun NavGraphBuilder.transactionGraph(navController: NavHostController) {
    composable(AppDestination.TransactionList.screenRoute) {
        TransactionListPage()
    }

    composable(
        route = AppDestination.TransactionAdd.screenRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Up,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Down,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Up,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Down,
                animationSpec = tween(700)
            )
        }
    ) {
        TransactionAddPage(navController)
    }
}