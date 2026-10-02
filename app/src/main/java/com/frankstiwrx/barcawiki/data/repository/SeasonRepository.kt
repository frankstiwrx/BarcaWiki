package com.frankstiwrx.barcawiki.data.repository

import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.data.source.SeasonDataSource

object SeasonRepository {

    fun getSeasons(): List<Season> {
        return SeasonDataSource.seasons
    }
    fun getSeasonById(id: Int): Season? {
        return SeasonDataSource.seasons.find { season ->
            season.id == id
        }
    }
}