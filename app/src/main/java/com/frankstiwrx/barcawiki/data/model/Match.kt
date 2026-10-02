package com.frankstiwrx.barcawiki.data.model

data class Match(
    val id: Int,
    val seasonId: Int,
    val competitionId: Int,
    val date: String,
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: Int?,
    val awayScore: Int?
)