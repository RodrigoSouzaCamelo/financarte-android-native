package br.com.rodrigo.financarte.ui.components.bottonnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.R
import br.com.rodrigo.financarte.ui.navigation.AppDestination
import br.com.rodrigo.financarte.ui.navigation.navigateTo
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun BottomNavigation(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavigationItem(
            title = AppDestination.Home.title,
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home",
                    modifier = Modifier.size(25.dp)
                )
            },
            onClick = { navController.navigateTo(AppDestination.Home.screenRoute) }
        )

        BottomNavigationItem(
            title = AppDestination.Home.title,
            icon = {
                Icon(
                    painterResource(id = R.drawable.ic_insert_chart),
                    contentDescription = "Home",
                    modifier = Modifier.size(25.dp)
                )
            },
            onClick = { navController.navigateTo(AppDestination.Overview.screenRoute) }
        )

        BottomNavigationActionItem(
            icon = Icons.Default.Add,
            onClick = { navController.navigateTo(AppDestination.TransactionAdd.screenRoute) }
        )

        BottomNavigationItem(
            title = AppDestination.Home.title,
            icon = {
                Icon(
                    Icons.AutoMirrored.Filled.List,
                    contentDescription = "Home",
                    modifier = Modifier.size(25.dp)
                )
            },
            onClick = { navController.navigateTo(AppDestination.TransactionList.screenRoute) }
        )

        BottomNavigationItem(
            title = AppDestination.Home.title,
            icon = {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Home",
                    modifier = Modifier.size(25.dp)
                )
            },
            onClick = { navController.navigateTo(AppDestination.More.screenRoute) }
        )
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable()
fun BottomNavigationPreview() {
    FinancarteTheme {
        val navController = rememberNavController()

        Column {
            BottomNavigation(navController = navController)
            HorizontalDivider()
        }
    }
}
