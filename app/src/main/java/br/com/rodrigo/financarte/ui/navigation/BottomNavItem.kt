package br.com.rodrigo.financarte.ui.navigation

import androidx.annotation.DrawableRes
import br.com.rodrigo.financarte.R

sealed class BottomNavItem(
    val title: String,
    @DrawableRes val icon: Int,
    val screenRoute: String
) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "Home")
    object Overview : BottomNavItem("Overview", R.drawable.ic_insert_chart, "Overview")
    object Transactions : BottomNavItem("Transactions", R.drawable.ic_format_list_bulleted, "Transações")

}