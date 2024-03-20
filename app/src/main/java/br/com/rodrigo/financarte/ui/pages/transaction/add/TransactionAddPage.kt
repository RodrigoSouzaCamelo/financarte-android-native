package br.com.rodrigo.financarte.ui.pages.transaction.add

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun TransactionAddPage(navHostController: NavHostController) {
    Text("Transaction Add Page")
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun TransactionAddPagePreview() {
    FinancarteTheme {
        val navHostController = rememberNavController()
        TransactionAddPage(navHostController = navHostController)
    }
}