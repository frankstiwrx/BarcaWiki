package com.frankstiwrx.barcawiki.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.data.repository.SeasonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SeasonsUiState(
    val seasons: List<Season> = emptyList()
)

class SeasonsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SeasonsUiState()
    )

    val uiState: StateFlow<SeasonsUiState> =
        _uiState.asStateFlow()

    init {
        loadSeasons()
    }

    private fun loadSeasons() {
        _uiState.value = SeasonsUiState(
            seasons = SeasonRepository.getSeasons()
        )
    }
}