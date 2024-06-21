package com.dev0kch.chatbot.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dev0kch.chatbot.R
import com.dev0kch.chatbot.presentation.screens.components.CardWithIcon
import com.dev0kch.chatbot.presentation.viewmodel.AuthenticationViewModel
import com.dev0kch.chatbot.ui.theme.cardBackgroundPrimary
import com.dev0kch.chatbot.ui.theme.cardBackgroundSecond
import com.dev0kch.chatbot.ui.theme.cardBackgroundThird
import com.dev0kch.chatbot.ui.theme.primary
import com.dev0kch.chatbot.ui.theme.second
import com.dev0kch.chatbot.ui.theme.textColorHint
import com.dev0kch.chatbot.ui.theme.textColorPrimary
import com.dev0kch.chatbot.utils.GlobalStyles


@Composable
fun HomeScreen(
    navController: NavHostController?,
   authenticationViewModel: AuthenticationViewModel = hiltViewModel()
) {



    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
            .padding(25.dp),


        ) {

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = textColorHint,
                        fontSize = GlobalStyles.Text.H2,
                        fontWeight = FontWeight.W300,
                    )
                ) {
                    append(stringResource(id = R.string.txt_hello))
                }


                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = textColorPrimary,
                        fontSize = GlobalStyles.Text.H2
                    )
                ) {
                    append(" James")
                }

            },
        )

        Text(
            text = stringResource(id = R.string.txt_how_assist_you), color = textColorHint,
            fontSize = GlobalStyles.Text.H4,
            fontWeight = FontWeight.W300,
            modifier = Modifier.padding(top = 15.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .height(240.dp)


        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .padding(end = 5.dp)

            ) {
                CardWithIcon(
                    text = stringResource(id = R.string.txt_talk_with_echo),
                    icon = painterResource(id = R.drawable.ic_micro),
                    fontSize = GlobalStyles.Text.H2,
                    background = cardBackgroundPrimary,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(bottomStart = 35.dp)),
                    textModifier = Modifier.fillMaxWidth(0.5f)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)

            ) {
                CardWithIcon(
                    text = stringResource(id = R.string.txt_chat_with_echo),
                    icon = painterResource(id = R.drawable.ic_send),
                    fontSize = GlobalStyles.Text.H4,
                    background = cardBackgroundSecond,
                    modifier = Modifier
                        .padding(start = 5.dp, bottom = 5.dp)
                        .height(120.dp),
                    textModifier = Modifier.fillMaxWidth()
                )

                CardWithIcon(
                    text = stringResource(id = R.string.txt_search_by_image),
                    icon = painterResource(id = R.drawable.ic_focus),
                    fontSize = GlobalStyles.Text.H4,
                    background = cardBackgroundThird,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 5.dp)
                        .height(120.dp)
                        .clip(shape = RoundedCornerShape(bottomEnd = 35.dp)),
                    textModifier = Modifier.fillMaxWidth()

                )
            }
        }


    }


}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(null)
}
