package com.dev0kch.chatbot.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dev0kch.chatbot.R
import com.dev0kch.chatbot.presentation.screens.components.GradientButton
import com.dev0kch.chatbot.presentation.navigation.Route
import com.dev0kch.chatbot.presentation.viewmodel.AuthenticationViewModel
import com.dev0kch.chatbot.ui.theme.background
import com.dev0kch.chatbot.ui.theme.primary
import com.dev0kch.chatbot.ui.theme.second
import com.dev0kch.chatbot.ui.theme.textColorHint
import com.dev0kch.chatbot.ui.theme.white
import com.dev0kch.chatbot.utils.GlobalStyles
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev0kch.chatbot.utils.Resource
import com.dev0kch.chatbot.utils.validateEmail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController?,
    authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {

    authenticationViewModel.loginFLow.value.let {
        when (it) {
            is Resource.Failure -> {

            }

            is Resource.Loading -> {

            }

            is Resource.Success -> {
                LaunchedEffect(Unit) {
                    navController?.navigate(Route.HomeScreen.route)
                }
            }

            else -> {}
        }
    }
    val listColors = listOf(second, primary)


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
            .padding(top = GlobalStyles.Padding.ScreenPadding)
    ) {

        Text(
            text = stringResource(id = R.string.txt_login_into_account),
            modifier = Modifier.padding(
                top = GlobalStyles.Padding.ScreenPadding,
                start = GlobalStyles.Padding.ScreenPadding,
                end = GlobalStyles.Padding.ScreenPadding,
                bottom = 10.dp


            ),
            color = white,
            fontSize = 20.sp,
            fontWeight = FontWeight.W600
        )

        Text(
            text = stringResource(id = R.string.txt_wlcm_back),
            modifier = Modifier.padding(
                start =
                GlobalStyles.Padding.ScreenPadding,
            ),
            color = textColorHint,
            fontSize = 13.sp,
            fontWeight = FontWeight.W400
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.security),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .padding(top = 50.dp),
                contentScale = ContentScale.Crop,

                )
        }

        TextField(
            shape = RoundedCornerShape(5),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = stringResource(id = R.string.txt_email), fontSize = 13.sp) },
            modifier = Modifier

                .fillMaxWidth()
                .padding(
                    GlobalStyles.Padding.ScreenPadding,
                ),
        )

        TextField(
            shape = RoundedCornerShape(5),

            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.txt_password), fontSize = 13.sp) },
            modifier = Modifier

                .fillMaxWidth()
                .padding(
                    start = GlobalStyles.Padding.ScreenPadding,
                    end = GlobalStyles.Padding.ScreenPadding
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 10.dp,
                    end = GlobalStyles.Padding.ScreenPadding
                ),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = stringResource(id = R.string.txt_forget_password),
                color = textColorHint,
                fontSize = 13.sp, fontWeight = FontWeight.W700
            )
        }

        GradientButton(
            gradientColors = listColors,
            cornerRadius = 5.dp, nameButton = stringResource(id = R.string.txt_login),
            roundedCornerShape = RoundedCornerShape(5.dp),
            modifier = Modifier.padding(top = 50.dp),
            onClick = { login(email, password, authenticationViewModel) }
        )
    }
}

private fun login(

    email: String,
    password: String,
    authenticationViewModel: AuthenticationViewModel
) {
    if (validateEmail(email) && password.length > 6) {
        authenticationViewModel.login(email, password)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = null)
}