package br.com.rodrigo.financarte.ui.pages.overview

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun OverviewPage(navHostController: NavHostController) {

    Text(text = "Overview Page")
}

@Preview
@Composable
fun OverviewPagePreview() {
    val navHostController = rememberNavController()

    FinancarteTheme {
        OverviewPage(navHostController)
    }
}