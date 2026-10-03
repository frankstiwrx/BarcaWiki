package com.frankstiwrx.barcawiki.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.data.model.SquadPlayer
import com.frankstiwrx.barcawiki.data.repository.SeasonRepository
import com.frankstiwrx.barcawiki.data.repository.SquadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SeasonSquadUiState(
    val season: Season? = null,
    val players: List<SquadPlayer> = emptyList()
)

class SeasonSquadViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SeasonSquadUiState()
    )

    val uiState: StateFlow<SeasonSquadUiState> =
        _uiState.asStateFlow()

    fun loadSquad(seasonId: Int) {

        _uiState.value = SeasonSquadUiState(
            season = SeasonRepository.getSeasonById(seasonId),
            players = SquadRepository.getSquadBySeason(seasonId)
        )
    }
}