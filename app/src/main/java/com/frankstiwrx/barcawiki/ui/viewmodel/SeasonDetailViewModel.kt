package com.frankstiwrx.barcawiki.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.data.repository.SeasonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.frankstiwrx.barcawiki.data.model.Coach
import com.frankstiwrx.barcawiki.data.model.Competition
import com.frankstiwrx.barcawiki.data.model.Match
import com.frankstiwrx.barcawiki.data.model.SquadEntry

data class SeasonDetailUiState(
    val season: Season? = null,
    val squad: List<SquadEntry> = emptyList(),
    val competitions: List<Competition> = emptyList(),
    val matches: List<Match> = emptyList(),
    val coaches: List<Coach> = emptyList()
)

class SeasonDetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SeasonDetailUiState()
    )

    val uiState: StateFlow<SeasonDetailUiState> =
        _uiState.asStateFlow()

    fun loadSeason(seasonId: Int) {
        _uiState.value = SeasonDetailUiState(
            season = SeasonRepository.getSeasonById(seasonId)
        )
    }
}