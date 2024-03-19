package br.com.rodrigo.financarte.ui.components.bottonnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationItem(title: String, icon: @Composable () -> Unit, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxHeight()
            .width(60.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            icon()
        }
    }
}