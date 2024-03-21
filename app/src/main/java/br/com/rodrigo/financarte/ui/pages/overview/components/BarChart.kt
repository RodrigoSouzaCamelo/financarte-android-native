package br.com.rodrigo.financarte.ui.pages.overview.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BarChart(
    data: Map<Float, String>,
    maxValue: Int
) {

    val context = LocalContext.current
    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(19.dp) }
    val barGraphSpace by remember { mutableStateOf(15.dp) }

    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(50.dp) }
    val scaleLineWidth by remember { mutableStateOf(1.dp) }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(265.dp)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(barGraphHeight),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Start
            ) {
                // scale Y-Axis
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(35.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = maxValue.toString(),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Spacer(modifier = Modifier.fillMaxHeight())
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = (maxValue / 2).toString(),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
                    }

                }

                // Y-Axis Line
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(scaleLineWidth)
                        .background(Color.Black)
                )

                // graph
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    data.forEach {
                        Box(
                            modifier = Modifier
                                .padding(start = barGraphSpace, bottom = 0.dp)
                                .width(barGraphWidth)
                                .clip(RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp))
                                .fillMaxHeight(it.key)
                                .background(MaterialTheme.colorScheme.primary)
                                .clickable {
                                    Toast
                                        .makeText(context, it.key.toString(), Toast.LENGTH_SHORT)
                                        .show()
                                }
                        )
                    }
                }
            }

            // X-Axis Line
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(scaleLineWidth)
                    .padding(start = 35.dp)
                    .background(Color.Black)
            )

            // Scale X-Axis
            Row(
                modifier = Modifier
                    .padding(start = 45.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                data.values.forEach {
                    Text(
                        modifier = Modifier.width(35.dp),
                        text = it,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun PreviewBarChar() {
    val data = mapOf(
        Pair(0.1f, "DOM"),
        Pair(0.2f, "SEG"),
        Pair(0.3f, "TER"),
        Pair(0.4f, "QUA"),
        Pair(0.5f, "QUI"),
        Pair(0.6f, "SEX"),
        Pair(0.8f, "SÁB")
    )

    BarChart(
        data = data,
        maxValue = 1000
    )
}
