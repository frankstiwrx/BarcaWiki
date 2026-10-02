package com.frankstiwrx.barcawiki.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frankstiwrx.barcawiki.data.model.Season
import com.frankstiwrx.barcawiki.ui.viewmodel.SeasonsViewModel

@Composable
fun SeasonsRoute(
    modifier: Modifier = Modifier,
    onSeasonClick: (Season) -> Unit = {},
    viewModel: SeasonsViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SeasonsScreen(
        seasons = uiState.seasons,
        modifier = modifier,
        onSeasonClick = onSeasonClick
    )
}