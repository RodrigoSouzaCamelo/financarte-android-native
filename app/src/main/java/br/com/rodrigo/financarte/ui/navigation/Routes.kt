package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.components.bottonnavigation.BottomNavigation
import br.com.rodrigo.financarte.ui.components.DrawerNavigation
import br.com.rodrigo.financarte.ui.components.TopBar

@ExperimentalMaterial3Api
@Composable
fun Routes() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    DrawerNavigation(drawerState) {
        Scaffold(
            topBar = { TopBar(drawerState) },
            bottomBar = { BottomNavigation(navController = navController) },
        ) { paddingValues ->
            AppNavHost(
                navController = navController,
                paddingValues = paddingValues
            )
        }
    }
}