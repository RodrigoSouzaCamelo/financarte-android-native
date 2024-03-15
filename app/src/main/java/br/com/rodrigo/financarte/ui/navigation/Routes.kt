package br.com.rodrigo.financarte.ui.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.components.BottomNavigation
import br.com.rodrigo.financarte.ui.navigation.NavigationGraph

@Composable
fun Routes(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) { paddingValues ->
        NavigationGraph(navController = navController, paddingValues = paddingValues)
    }
}