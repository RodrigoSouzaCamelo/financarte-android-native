package br.com.rodrigo.financarte.ui.navigation

sealed class BottomNavItem(
    val title: String,
    val screenRoute: String
) {
    object Home : BottomNavItem(title = "Home", screenRoute = "Home")
    object Overview : BottomNavItem(title = "Overview", screenRoute = "Overview")
    object Transactions : BottomNavItem(title = "Transactions", screenRoute = "Transações")
    object More : BottomNavItem(title = "More", screenRoute = "More")
}