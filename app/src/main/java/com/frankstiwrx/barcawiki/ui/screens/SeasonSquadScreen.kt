package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankstiwrx.barcawiki.data.model.SquadPlayer
import com.frankstiwrx.barcawiki.ui.theme.BarcaBlue
import com.frankstiwrx.barcawiki.ui.theme.BarcaGarnet

@Composable
fun SeasonSquadScreen(
    seasonId: Int,
    players: List<SquadPlayer>,
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
            text = "Elenco",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Jogadores da temporada • ID $seasonId",
            color = Color.White.copy(alpha = 0.80f),
            fontSize = 16.sp
        )

        Text(
            text = "${players.size} jogadores carregados",
            color = Color.White.copy(alpha = 0.80f),
            fontSize = 14.sp
        )

        // AQUI entra a lista dos jogadores
        players.forEach { squadPlayer ->

            Text(
                text = "${squadPlayer.shirtNumber ?: "-"} • ${squadPlayer.player.name}",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp)
            )

            Text(
                text = squadPlayer.player.position,
                color = Color.White.copy(alpha = 0.70f),
                fontSize = 14.sp
            )
        }
    }
}