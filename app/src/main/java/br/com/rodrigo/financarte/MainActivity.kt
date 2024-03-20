package br.com.rodrigo.financarte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.components.bottonnavigation.BottomNavigation
import br.com.rodrigo.financarte.ui.navigation.AppNavHost
import br.com.rodrigo.financarte.ui.navigation.AppDestination
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinancarteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    val showBottomAppBar = currentRoute == AppDestination.TransactionAdd.screenRoute

                    Scaffold(
                        bottomBar = {
                            if (!showBottomAppBar) BottomNavigation(navController = navController)
                            else null
                        },
                    ) { paddingValues ->
                        AppNavHost(
                            navController = navController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}