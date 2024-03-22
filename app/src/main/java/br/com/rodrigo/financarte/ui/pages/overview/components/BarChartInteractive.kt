package br.com.rodrigo.financarte.ui.pages.overview.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme
import br.com.rodrigo.financarte.util.Currency

data class BarChartModel(
    val title: String,
    val value: Float,
    val active: Boolean = false
)

@Composable
fun BarChartInteractive(
    title: String = "",
    data: MutableList<BarChartModel>,
    modifier: Modifier = Modifier
) {
    val dataReceive = remember { mutableStateOf(data) }
    val maxValue = dataReceive.value.maxOf { it.value }
    val sumAllValues: Float = data.sumOf { it.value.toDouble() }.toFloat()

    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelLarge
                    )

                    Text(
                        text = Currency.formatCurrency(sumAllValues),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                dataReceive.value.mapIndexed { i, it ->
                    Bar(
                        bar = it,
                        maxValue = maxValue,
                        onClick = {
                            dataReceive.value = dataReceive.value.mapIndexed { i2, bar ->
                                if (i == i2) {
                                    bar.copy(active = !bar.active)
                                } else {
                                    bar.copy(active = false)
                                }
                            }.toMutableList()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Bar(bar: BarChartModel, maxValue: Float, onClick: () -> Unit, modifier: Modifier = Modifier) {
    val barHeight = bar.value / maxValue
    val barColor = if (bar.active) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.secondary


    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .padding(vertical = 10.dp)
    ) {
        if (bar.active) {
            TooltipChart(bar = bar)
        }

        Row(verticalAlignment = Alignment.Bottom) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .fillMaxHeight(barHeight)
                    .width(20.dp)
                    .background(barColor)
                    .clickable { onClick() }
            )
        }
    }
}

@Composable
fun TooltipChart(bar: BarChartModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(100.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray)
        ) {
            Row {
                Text(
                    text = bar.title,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Row {
                Text(
                    text = Currency.formatCurrency(bar.value),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

        VerticalDivider(
            color = Color.Gray,
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
                .padding(start = 9.dp)
        )
    }

}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun BarChartInteractivePreview() {
    var dataReceive = mutableListOf(
        BarChartModel(title = "Domingo", value = 200f, active = true),
        BarChartModel(title = "Segunda", value = 300f),
        BarChartModel(title = "Terça", value = 150.2f),
        BarChartModel(title = "Quarta", value = 170.3f),
        BarChartModel(title = "Quinta", value = 140.4f),
        BarChartModel(title = "Sexta", value = 100.5f),
        BarChartModel(title = "Sábado", value = 200.6f),
    )

    FinancarteTheme {
        BarChartInteractive(title = "Ganho semanal", data = dataReceive)
    }
}