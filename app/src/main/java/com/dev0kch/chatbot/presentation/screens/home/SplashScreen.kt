package com.dev0kch.chatbot.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dev0kch.chatbot.R
import com.dev0kch.chatbot.presentation.components.GradientButton
import com.dev0kch.chatbot.presentation.navigation.Route
import com.dev0kch.chatbot.ui.theme.primary
import com.dev0kch.chatbot.ui.theme.second
import com.dev0kch.chatbot.utils.GloablStyles


@Composable
fun SplashScreen(navController: NavHostController) {

    val listColors = listOf(second, primary)


    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.robot),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp),
            contentScale = ContentScale.Crop,
        )


        Text(

            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colorResource(id = R.color.white))) {
                    append(stringResource(id = R.string.splash_msg))
                }
                withStyle(style = SpanStyle(colorResource(id = R.color.primary))) {
                    append(" " + stringResource(id = R.string.txt_ai_assistant))
                }
            },

            fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = GloablStyles.Padding.ScreenPadding,top = GloablStyles.Padding.ScreenPadding,),
            fontWeight = FontWeight.W300,
            lineHeight = 50.sp,

            )


        Text(
            text = stringResource(id = R.string.txt_spalsh_small_msg),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = GloablStyles.Padding.ScreenPadding ,start= GloablStyles.Padding.ScreenPadding, top = 35.dp),
            color = Color.White,
            lineHeight = 30.sp,
            fontSize = 17.sp,
            fontWeight = FontWeight.W300,
        )

        GradientButton(
            gradientColors = listColors,
            cornerRadius = 25.dp,
            nameButton = stringResource(id = R.string.txt_next),
            roundedCornerShape = RoundedCornerShape(0),
            Modifier.padding(top = 100.dp),
            onClick =   { navController.navigate(Route.LoginScreen.route) }
        )

    }


}