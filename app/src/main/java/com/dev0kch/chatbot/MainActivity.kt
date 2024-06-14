package com.dev0kch.chatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev0kch.chatbot.presentation.navigation.HomeNavigation
import com.dev0kch.chatbot.presentation.navigation.Route
import com.dev0kch.chatbot.ui.theme.ChatbotTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatbotTheme {
                HomeNavigation(startDestination = Route.SplashScreen.route)
            }
        }
    }
}

