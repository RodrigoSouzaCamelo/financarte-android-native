package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavigationGraph(navController = navController, paddingValues = paddingValues)
}