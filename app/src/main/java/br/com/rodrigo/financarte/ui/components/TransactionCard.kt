package br.com.rodrigo.financarte.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionCard() {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp)
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = null
                )

                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = "Supermercado", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "14/01/2024", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                }
            }

            VerticalDivider()
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "R$ 100", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "10x", color = MaterialTheme.colorScheme.secondary, fontSize = 12.sp)
                }
            }
        }
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun TransactionCardPreview() {
    FinancarteTheme {
        TransactionCard()
    }
}