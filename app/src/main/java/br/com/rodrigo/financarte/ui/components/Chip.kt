package br.com.rodrigo.financarte.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun Chip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: @Composable (() -> Unit)? = null
) {
    val backgroundColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray
    val contentColor = if (selected) Color.White else Color.Black

    Surface(
        modifier = modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (icon != null) {
                Box(modifier = Modifier.padding(end = 10.dp)) {
                    icon()
                }
            }

            Text(
                text = text,
                color = contentColor
            )
        }
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun ChipPreview() {
    FinancarteTheme {
        Chip(text = "Chip", selected = false, onClick = {})
    }
}