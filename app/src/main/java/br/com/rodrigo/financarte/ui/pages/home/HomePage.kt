package br.com.rodrigo.financarte.ui.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.ui.components.TransactionCard
import br.com.rodrigo.financarte.ui.navigation.navigateTo
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun HomePage(navHostController: NavHostController) {
    Header()

    Column(
        modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AccountBalanceCard()
        Text(
            text = "Transações",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
        )

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
            .height(180.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp)
            ) {
                Text(
                    text = "Saldo em conta",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 15.dp, top = 15.dp)
                )

                Text(
                    text = "R$ 1000",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp, bottom = 5.dp)
                )
            }
        }

        HorizontalDivider(modifier = Modifier.padding(start = 15.dp, end = 15.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp)
                    .weight(1f)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .rotate(90f)
                            .background(Color(0xFF4CAF50))
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Receita", fontSize = 14.sp)
                    }

                    Row {
                        Text(
                            text = "R$ 1000",
                            fontSize = 24.sp,
                            color = Color(0xFF4CAF50)
                        )
                    }
                }
            }


            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )  {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .rotate(270f)
                            .background(MaterialTheme.colorScheme.error)
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(16.dp)

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(text = "Despesa", fontSize = 14.sp)
                    }

                    Row {
                        Text(
                            text = "R$ 500",
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true, apiLevel = 33)
@Composable
fun HomePagePreview() {
    val navHostController = rememberNavController()
    FinancarteTheme {
        HomePage(navHostController)
    }
}