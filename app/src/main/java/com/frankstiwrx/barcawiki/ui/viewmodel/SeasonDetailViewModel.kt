package com.frankstiwrx.barcawiki.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.data.repository.SeasonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SeasonDetailUiState(
    val season: Season? = null
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