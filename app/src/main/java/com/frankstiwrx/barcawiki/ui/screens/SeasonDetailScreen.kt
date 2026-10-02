package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
fun SeasonDetailScreen(
    season: Season,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        BarcaBlue,
                        BarcaGarnet
                    )
                )
            ),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {

            Text(
                text = season.name,
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = "Temporada ${season.startYear} - ${season.endYear}",
                color = Color.White.copy(alpha = 0.80f),
                fontSize = 16.sp
            )

            Spacer(
                modifier = Modifier.height(28.dp)
            )

            Text(
                text = "Visão geral",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        item {
            SeasonSectionCard(
                title = "Elenco",
                description = "Jogadores da temporada"
            )
        }

        item {
            SeasonSectionCard(
                title = "Competições",
                description = "Campanhas e títulos"
            )
        }

        item {
            SeasonSectionCard(
                title = "Partidas",
                description = "Todos os jogos da temporada"
            )
        }

        item {
            SeasonSectionCard(
                title = "Estatísticas",
                description = "Números e desempenho"
            )
        }
    }
}

@Composable
fun SeasonSectionCard(
    title: String,
    description: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.12f)
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                text = description,
                color = Color.White.copy(alpha = 0.80f),
                fontSize = 14.sp
            )
        }
    }
}