package com.frankstiwrx.barcawiki.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frankstiwrx.barcawiki.ui.screens.HomeScreen
import com.frankstiwrx.barcawiki.ui.screens.WelcomeScreen
import com.frankstiwrx.barcawiki.ui.screens.SeasonsScreen

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
            SeasonsScreen()
        }

    }
}