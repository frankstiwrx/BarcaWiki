package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.ui.theme.BarcaBlue
import com.frankstiwrx.barcawiki.ui.theme.BarcaGarnet

@Composable
fun SeasonDetailScreen(
    season: Season,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        BarcaBlue,
                        BarcaGarnet
                    )
                )
            )
            .padding(24.dp)
    ) {

        Text(
            text = season.name,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Temporada ${season.startYear} - ${season.endYear}",
            color = Color.White.copy(alpha = 0.80f),
            fontSize = 16.sp
        )
    }
}