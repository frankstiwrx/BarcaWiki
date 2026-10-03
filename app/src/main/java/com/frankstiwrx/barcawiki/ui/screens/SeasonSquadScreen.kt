package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    seasonName: String,
    players: List<SquadPlayer>,
    modifier: Modifier = Modifier
) {

    val goalkeepers = players.filter {
        it.player.position == "Goleiro"
    }

    val defenders = players.filter {
        it.player.position == "Defensor"
    }

    val midfielders = players.filter {
        it.player.position == "Meio-campista"
    }

    val forwards = players.filter {
        it.player.position == "Atacante"
    }

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
            )
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        item {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Elenco",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Temporada $seasonName",
                color = Color.White.copy(alpha = 0.80f),
                fontSize = 16.sp
            )

            Text(
                text = "${players.size} jogadores no elenco",
                color = Color.White.copy(alpha = 0.65f),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        squadSection(
            title = "GOLEIROS",
            players = goalkeepers
        )

        squadSection(
            title = "DEFENSORES",
            players = defenders
        )

        squadSection(
            title = "MEIO-CAMPISTAS",
            players = midfielders
        )

        squadSection(
            title = "ATACANTES",
            players = forwards
        )

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

private fun androidx.compose.foundation.lazy.LazyListScope.squadSection(
    title: String,
    players: List<SquadPlayer>
) {

    if (players.isEmpty()) {
        return
    }

    item {

        Text(
            text = title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = 12.dp,
                bottom = 4.dp
            )
        )
    }

    items(
        items = players,
        key = { squadPlayer ->
            squadPlayer.player.id
        }
    ) { squadPlayer ->

        SeasonSquadPlayerCard(
            squadPlayer = squadPlayer
        )
    }
}

@Composable
private fun SeasonSquadPlayerCard(
    squadPlayer: SquadPlayer
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.12f)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(68.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = squadPlayer.player.name
                        .take(1)
                        .uppercase(),
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = squadPlayer.player.name,
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = squadPlayer.player.fullName,
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${squadPlayer.player.nationality} • ${squadPlayer.player.position}",
                    color = Color.White.copy(alpha = 0.80f),
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = squadPlayer.shirtNumber?.toString() ?: "-",
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}