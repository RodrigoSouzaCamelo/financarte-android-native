package br.com.rodrigo.financarte.ui.pages.overview.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BarChart(
    data: List<Pair<String, Float>>,
    barWidth: Dp = 100.dp,
    titleTextSize: Dp = 25.dp,
    valueTextSize: Dp = 25.dp,
    paddingBetweenBars: Dp = 20.dp,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary

    val maxValue = data.maxOf { it.second }
    val canvasHeight = 300.dp

    Card(modifier = modifier) {
        Column(modifier.padding(16.dp)) {
            Text("Ganhos por dia da semana", Modifier.padding(bottom = 8.dp))
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(canvasHeight)
            ) {
                val startX = 0f
                val startY = size.height
                val endX = size.width
                val endY = size.height

                // Desenha o eixo x
                drawLine(
                    color = Color.Black,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = 2f
                )

                val maxBarHeight = size.height * 0.8f

                data.forEachIndexed { index, (day, value) ->
                    val barHeight = (value / maxValue) * maxBarHeight

                    val x = index * (barWidth.value + paddingBetweenBars.value) + barWidth.value / 2
                    val y = size.height - barHeight

                    // Desenha a barra
                    drawRect(
                        color = primaryColor,
                        topLeft = Offset(x - barWidth.value / 2, y),
                        size = Size(barWidth.value, barHeight)
                    )

                    // Desenha o dia abaixo da barra
                    drawLine(
                        color = Color.Black,
                        start = Offset(x, startY),
                        end = Offset(x, startY + 8.dp.value),
                        strokeWidth = 2f
                    )

                    // Desenha o texto do dia
                    drawIntoCanvas { canvas ->
                        val paint = Paint().apply {
                            color = android.graphics.Color.BLACK
                            textSize = titleTextSize.value
                        }
                        canvas.nativeCanvas.drawText(
                            day.uppercase(),
                            x - 20f,
                            startY + 35.dp.value,
                            paint
                        )
                    }

                    // Desenha o valor acima da barra
                    drawIntoCanvas { canvas ->
                        val paint = Paint().apply {
                            color = android.graphics.Color.BLACK
                            textSize = valueTextSize.value
                        }
                        canvas.nativeCanvas.drawText(
                            "R$ ${value.toString().split('.')[0]}",
                            x - 35f,
                            y - 8.dp.value,
                            paint
                        )
                    }
                }
            }
        }
    }
}


@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun PreviewBarChar() {
    val data = listOf(
        "Seg" to 100f,
        "Ter" to 200f,
        "Qua" to 150f,
        "Qui" to 300f,
        "Sex" to 250f,
        "Sáb" to 180f,
        "Dom" to 220f
    )

    BarChart(
        data = data,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}
