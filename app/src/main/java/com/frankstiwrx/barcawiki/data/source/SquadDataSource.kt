package com.frankstiwrx.barcawiki.data.source

import com.frankstiwrx.barcawiki.data.model.SquadEntry

object SquadDataSource {

    val squadEntries = listOf(

        SquadEntry(
            id = 1,
            seasonId = 3,
            playerId = 1,
            shirtNumber = 13
        ),

        SquadEntry(
            id = 2,
            seasonId = 3,
            playerId = 2,
            shirtNumber = 2
        ),

        SquadEntry(
            id = 3,
            seasonId = 3,
            playerId = 3,
            shirtNumber = 8
        ),

        SquadEntry(
            id = 4,
            seasonId = 3,
            playerId = 4,
            shirtNumber = 19
        ),

        SquadEntry(
            id = 5,
            seasonId = 3,
            playerId = 5,
            shirtNumber = 11
        )
    )
}