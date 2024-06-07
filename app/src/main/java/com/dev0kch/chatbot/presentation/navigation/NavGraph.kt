package com.dev0kch.chatbot.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev0kch.chatbot.presentation.screens.home.HomeScreen
import com.dev0kch.chatbot.presentation.screens.home.SplashScreen


@Composable
fun HomeNavigation(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = Route.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = Route.HomeScreen.route) {

            HomeScreen(navController)
        }
    }
}