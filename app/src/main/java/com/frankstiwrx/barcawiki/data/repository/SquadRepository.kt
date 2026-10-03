package com.frankstiwrx.barcawiki.data.repository

import com.frankstiwrx.barcawiki.data.model.SquadPlayer
import com.frankstiwrx.barcawiki.data.source.PlayerDataSource
import com.frankstiwrx.barcawiki.data.source.SquadDataSource

object SquadRepository {

    fun getSquadBySeason(seasonId: Int): List<SquadPlayer> {

        val entries = SquadDataSource.squadEntries
            .filter { entry ->
                entry.seasonId == seasonId
            }

        return entries.mapNotNull { entry ->

            val player = PlayerDataSource.players.find { player ->
                player.id == entry.playerId
            }

            player?.let {
                SquadPlayer(
                    player = it,
                    shirtNumber = entry.shirtNumber
                )
            }
        }
    }
}