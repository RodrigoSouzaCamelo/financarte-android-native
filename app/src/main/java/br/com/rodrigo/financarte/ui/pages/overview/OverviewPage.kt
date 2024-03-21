package br.com.rodrigo.financarte.ui.pages.overview

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.pages.overview.components.BarChart
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun OverviewPage(navHostController: NavHostController) {
    val data = mapOf(
        Pair(0.1f, "DOM"),
        Pair(0.2f, "SEG"),
        Pair(0.3f, "TER"),
        Pair(0.4f, "QUA"),
        Pair(0.5f, "QUI"),
        Pair(0.6f, "SEX"),
        Pair(0.8f, "SÁB")
    )

    Text(text = "Overview Page")

    BarChart(data = data, maxValue = 1000)
}

@Preview
@Composable
fun OverviewPagePreview() {
    val navHostController = rememberNavController()

    FinancarteTheme {
        OverviewPage(navHostController)
    }
}