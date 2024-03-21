package br.com.rodrigo.financarte.ui.pages.more

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun MorePage(navHostController: NavHostController) {
    Text("More Page")
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun MorePagePreview() {
    val navHostController = rememberNavController()

    FinancarteTheme {
        MorePage(navHostController)
    }
}