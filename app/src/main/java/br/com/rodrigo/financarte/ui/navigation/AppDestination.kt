package br.com.rodrigo.financarte.ui.navigation

sealed class AppDestination(
    val title: String,
    val screenRoute: String
) {
    object Home : AppDestination(title = "Home", screenRoute = "Home")
    object Overview : AppDestination(title = "Overview", screenRoute = "Overview")
    object TransactionList : AppDestination(title = "Transação", screenRoute = "Transaction")
    object TransactionAdd : AppDestination(title = "Adicionar Transação", screenRoute = "TransactionAdd")
    object More : AppDestination(title = "Mais", screenRoute = "More")

}