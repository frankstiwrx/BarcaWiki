package com.frankstiwrx.barcawiki.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frankstiwrx.barcawiki.ui.screens.HomeScreen
import com.frankstiwrx.barcawiki.ui.screens.WelcomeScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonsRoute
import com.frankstiwrx.barcawiki.ui.screens.SeasonDetailRoute
import com.frankstiwrx.barcawiki.ui.screens.SeasonSquadScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonCompetitionsScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonMatchesScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonStatisticsScreen

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

            if (seasonId != null) {
                SeasonDetailRoute(
                    seasonId = seasonId,

                    onSquadClick = {
                        navController.navigate("season/$seasonId/squad")
                    },

                    onCompetitionsClick = {
                        navController.navigate("season/$seasonId/competitions")
                    },

                    onMatchesClick = {
                        navController.navigate("season/$seasonId/matches")
                    },

                    onStatisticsClick = {
                        navController.navigate("season/$seasonId/statistics")
                    }
                )
            }
        }
        composable("season/{seasonId}/squad") {
            SeasonSquadScreen()
        }

        composable("season/{seasonId}/competitions") {
            SeasonCompetitionsScreen()
        }

        composable("season/{seasonId}/matches") {
            SeasonMatchesScreen()
        }

        composable("season/{seasonId}/statistics") {
            SeasonStatisticsScreen()
        }
        composable("season/{seasonId}/squad") {
            SeasonSquadScreen()
        }
    }
}