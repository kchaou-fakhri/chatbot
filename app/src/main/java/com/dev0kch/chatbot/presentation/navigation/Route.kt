package com.dev0kch.chatbot.presentation.navigation

sealed class Route(val route : String){
    object SplashScreen : Route(route = "SplashScreen")
    object HomeScreen : Route(route = "HomeScreen")
}
