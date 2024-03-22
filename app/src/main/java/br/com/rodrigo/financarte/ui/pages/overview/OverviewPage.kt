package br.com.rodrigo.financarte.ui.pages.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.rodrigo.financarte.R
import br.com.rodrigo.financarte.ui.navigation.navigateTo
import br.com.rodrigo.financarte.ui.pages.overview.components.BarChartInteractive
import br.com.rodrigo.financarte.ui.pages.overview.components.BarChartModel
import br.com.rodrigo.financarte.ui.theme.FinancarteTheme

@Composable
fun OverviewPage(navHostController: NavHostController) {
    var dataReceive = mutableListOf(
        BarChartModel(title = "Domingo", value = 200f, active = true),
        BarChartModel(title = "Segunda", value = 300f),
        BarChartModel(title = "Terça", value = 150.2f),
        BarChartModel(title = "Quarta", value = 170.3f),
        BarChartModel(title = "Quinta", value = 140.4f),
        BarChartModel(title = "Sexta", value = 100.5f),
        BarChartModel(title = "Sábado", value = 200.6f),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Header()

        BarChartInteractive(
            title = "Ganho semanal",
            data = dataReceive,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}

@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.secondaryContainer,
                contentDescription = null
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_filter_alt),
                tint = MaterialTheme.colorScheme.secondaryContainer,
                contentDescription = null
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                tint = MaterialTheme.colorScheme.secondaryContainer,
                contentDescription = null
            )
        }
        Text(text = "Março", color = MaterialTheme.colorScheme.secondaryContainer)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                tint = MaterialTheme.colorScheme.secondaryContainer,
                contentDescription = null
            )
        }
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun OverviewPagePreview() {
    val navHostController = rememberNavController()

    FinancarteTheme {
        OverviewPage(navHostController)
    }
}