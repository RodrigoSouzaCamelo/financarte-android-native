package br.com.rodrigo.financarte.ui.navigation

import androidx.annotation.DrawableRes
import br.com.rodrigo.financarte.R

sealed class DrawerNavItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val badgeCount: Int? = null
) {
    object Home : DrawerNavItem(
        title = "Home",
        selectedIcon = R.drawable.ic_home,
        unselectedIcon = R.drawable.ic_home,
    )
    object Overview : DrawerNavItem(
        title = "Overview",
        selectedIcon = R.drawable.ic_insert_chart,
        unselectedIcon = R.drawable.ic_insert_chart
    )
    object Transactions : DrawerNavItem(
        title = "Transactions",
        selectedIcon = R.drawable.ic_format_list_bulleted,
        unselectedIcon = R.drawable.ic_format_list_bulleted
    )
}