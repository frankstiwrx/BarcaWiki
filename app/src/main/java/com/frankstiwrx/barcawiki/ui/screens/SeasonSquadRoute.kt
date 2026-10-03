package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frankstiwrx.barcawiki.ui.viewmodel.SeasonSquadViewModel

@Composable
fun SeasonSquadRoute(
    seasonId: Int,
    viewModel: SeasonSquadViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(seasonId) {
        viewModel.loadSquad(seasonId)
    }

    SeasonSquadScreen(
        seasonName = uiState.season?.name ?: "",
        players = uiState.players
    )
}