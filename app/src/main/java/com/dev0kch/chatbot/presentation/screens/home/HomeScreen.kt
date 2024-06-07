package com.dev0kch.chatbot.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.dev0kch.chatbot.R
import com.dev0kch.chatbot.ui.theme.primary
import com.dev0kch.chatbot.ui.theme.second


@Composable
fun HomeScreen(navController: NavHostController) {

    val listColors = listOf(second, primary)


    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally

    ) {



    }


}