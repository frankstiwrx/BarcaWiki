package com.frankstiwrx.barcawiki.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frankstiwrx.barcawiki.ui.screens.HomeScreen
import com.frankstiwrx.barcawiki.ui.screens.WelcomeScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonsRoute
import com.frankstiwrx.barcawiki.data.repository.SeasonRepository
import com.frankstiwrx.barcawiki.ui.screens.SeasonDetailScreen

@Composable
fun BarcaWikiNavHost(
    modifier: Modifier = Modifier
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome",
        modifier = modifier
    ) {

        composable("welcome") {
            WelcomeScreen(
                onEnter = {
                    navController.navigate("home")
                }
            )
        }

        composable("home") {
            HomeScreen(
                onSeasonsClick = {
                    navController.navigate("seasons")
                }
            )
        }

        composable("seasons") {
            SeasonsRoute(
                onSeasonClick = { season ->
                    navController.navigate("season/${season.id}")
                }
            )
        }

        composable("season/{seasonId}") { backStackEntry ->

            val seasonId = backStackEntry.arguments
                ?.getString("seasonId")
                ?.toIntOrNull()

            val season = seasonId?.let {
                SeasonRepository.getSeasonById(it)
            }

            if (season != null) {
                SeasonDetailScreen(
                    season = season
                )
            }
        }

    }
}