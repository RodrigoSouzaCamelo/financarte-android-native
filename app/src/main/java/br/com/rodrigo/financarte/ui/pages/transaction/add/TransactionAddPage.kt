package br.com.rodrigo.financarte.ui.pages.transaction.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.R
import br.com.rodrigo.financarte.model.TransactionType
import br.com.rodrigo.financarte.ui.components.Chip
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun TransactionAddPage(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navHostController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }

            Text(text = "Nova transação", style = MaterialTheme.typography.bodyLarge)
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(top = 15.dp, start = 15.dp)) {
                Text(text = "Valor da transação", style = MaterialTheme.typography.bodySmall)
                Text(text = "R$ 0,00", style = MaterialTheme.typography.displaySmall)
            }
        }

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(60.dp)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.List,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    BasicTextField(
                        value = "Descrição",
                        onValueChange = {},
                        singleLine = true,
                        textStyle = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    )
                }

                HorizontalDivider(modifier = Modifier.padding(start = 20.dp, end = 20.dp))

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(60.dp)
                ) {
                    var selectedChip by remember { mutableStateOf(TransactionType.Receita) }

                    Icon(
                        painter = painterResource(id = R.drawable.ic_attach_money),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 15.dp)
                    )

                    Chip(
                        text = "Receita",
                        selected = selectedChip == TransactionType.Receita,
                        onClick = { selectedChip = TransactionType.Receita },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_trending_up),
                                contentDescription = null
                            )
                        },
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Chip(
                        text = "Dívida",
                        selected = selectedChip == TransactionType.Despesa,
                        onClick = { selectedChip = TransactionType.Despesa },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_trending_down),
                                contentDescription = null
                            )
                        }
                    )
                }

                HorizontalDivider(modifier = Modifier.padding(start = 20.dp, end = 20.dp))

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(bottom = 15.dp)
                            .size(55.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(
                            tint = Color.White,
                            imageVector = Icons.Default.Check,
                            contentDescription = "Confirm add transaction"
                        )
                    }
                }
            }
        }
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun TransactionAddPagePreview() {
    FinancarteTheme {
        val navHostController = rememberNavController()
        TransactionAddPage(navHostController = navHostController)
    }
}