package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun SeasonsScreen(
    seasons: List<Season>,
    modifier: Modifier = Modifier,
    onSeasonClick: (Season) -> Unit = {}
) {

    Box(
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
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Text(
                    text = "Temporadas",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "Explore a história do FC Barcelona temporada por temporada",
                    color = Color.White.copy(alpha = 0.80f),
                    fontSize = 14.sp
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )
            }

            items(seasons) { season ->

                SeasonCard(
                    season = season,
                    onClick = {
                        onSeasonClick(season)
                    }
                )
            }
        }
    }
}

@Composable
fun SeasonCard(
    season: Season,
    onClick: () -> Unit
) {

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.12f)
        )
    ) {

        Text(
            text = season.name,
            modifier = Modifier.padding(20.dp),
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}