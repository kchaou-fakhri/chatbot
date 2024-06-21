package com.dev0kch.chatbot.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev0kch.chatbot.R
import com.dev0kch.chatbot.ui.theme.cardBackgroundPrimary
import com.dev0kch.chatbot.ui.theme.textColorInCard
import com.dev0kch.chatbot.ui.theme.transparent
import com.dev0kch.chatbot.utils.GlobalStyles


@Composable
fun CardWithIcon(
    text: String,
    icon: Painter,
    fontSize: TextUnit,
    background: Color,
    modifier: Modifier,
    textModifier : Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = background,
        ),

        modifier = Modifier.fillMaxWidth().then(modifier)


    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(65.dp)
                .height(60.dp)
                .padding(start = 15.dp, top = 10.dp)
                .background(transparent, shape = RoundedCornerShape(25.dp))

        ) {
            Image(
                painter = icon, contentDescription = "", modifier = Modifier.width(18.dp)


            )
        }

        Text(
            text,
            modifier = Modifier
                .padding(15.dp)
                .then(textModifier)
                ,
            fontSize = fontSize,
            lineHeight = 40.sp,
            fontWeight = FontWeight.W400,
            color = textColorInCard
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun CardWithIconPreview() {
    CardWithIcon(
        text = stringResource(id = R.string.txt_talk_with_echo),
        icon = painterResource(id = R.drawable.ic_send),
        fontSize = GlobalStyles.Text.H1,
        background = cardBackgroundPrimary,
        modifier = Modifier
    )
}