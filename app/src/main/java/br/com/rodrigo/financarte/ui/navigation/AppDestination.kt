package br.com.rodrigo.financarte.ui.navigation

sealed class AppDestination(
    val title: String,
    val screenRoute: String
) {
    data object Home : AppDestination(title = "Home", screenRoute = "Home")
    data object More : AppDestination(title = "Mais", screenRoute = "More")
    data object Overview : AppDestination(title = "Overview", screenRoute = "Overview")
    data object TransactionList : AppDestination(title = "Transação", screenRoute = "Transaction")
    data object TransactionAdd : AppDestination(title = "Adicionar Transação", screenRoute = "TransactionAdd")

}