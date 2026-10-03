package com.frankstiwrx.barcawiki.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.frankstiwrx.barcawiki.data.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SeasonSquadUiState(
    val players: List<Player> = emptyList()
)

class SeasonSquadViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SeasonSquadUiState()
    )

    val uiState: StateFlow<SeasonSquadUiState> =
        _uiState.asStateFlow()
}