package br.com.rodrigo.financarte.ui.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.financarte.ui.components.TransactionCard
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun HomePage(){
    Header()

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AccountBalanceCard()
        TransactionCard()
        TransactionCard()
        TransactionCard()
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Composable
fun AccountBalanceCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(155.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "R$ 1000",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 15.dp, start = 15.dp)
                )

                Text(
                    text = "Balanço geral",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(start = 15.dp, bottom = 15.dp)
                )
                
                HorizontalDivider(
                    modifier = Modifier
                        .padding(start = 15.dp, end = 15.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 5.dp, start = 15.dp, end = 15.dp)
                    ) {

                    Column(horizontalAlignment = Alignment.Start) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Entrada", fontSize = 14.sp)
                            Icon(
                                Icons.Filled.KeyboardArrowUp,
                                contentDescription = null,
                                Modifier.size(25.dp)
                            )
                        }
                        Row {
                            Text(
                                text = "R$ 500",
                                fontSize = 20.sp,
                                color = Color(0xFF4CAF50)
                            )
                        }
                    }

                    Column(horizontalAlignment = Alignment.Start) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Saída", fontSize = 14.sp)
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = null,
                                Modifier.size(25.dp)
                            )
                        }
                        Row {
                            Text(
                                text = "R$ 500",
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true, apiLevel = 33)
@Composable
fun HomePagePreview() {
    FinancarteTheme {
        HomePage()
    }
}