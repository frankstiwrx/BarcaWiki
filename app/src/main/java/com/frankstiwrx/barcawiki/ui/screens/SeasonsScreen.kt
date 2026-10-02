package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankstiwrx.barcawiki.data.model.Season

@Composable
fun SeasonsScreen(
    modifier: Modifier = Modifier
) {

    val seasons = listOf(
        Season(
            id = 1,
            name = "2026/27",
            startYear = 2026,
            endYear = 2027
        ),
        Season(
            id = 2,
            name = "2025/26",
            startYear = 2025,
            endYear = 2026
        ),
        Season(
            id = 3,
            name = "2024/25",
            startYear = 2024,
            endYear = 2025
        )
    )
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Temporadas",
            fontSize = 28.sp
        )
        seasons.forEach { season ->
            Text(
                text = season.name
            )
        }
    }
}