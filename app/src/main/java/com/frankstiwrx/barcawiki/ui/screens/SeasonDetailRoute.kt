package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frankstiwrx.barcawiki.ui.viewmodel.SeasonDetailViewModel

@Composable
fun SeasonDetailRoute(
    seasonId: Int,
    viewModel: SeasonDetailViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(seasonId) {
        viewModel.loadSeason(seasonId)
    }

    uiState.season?.let { season ->
        SeasonDetailScreen(
            season = season
        )
    }
}