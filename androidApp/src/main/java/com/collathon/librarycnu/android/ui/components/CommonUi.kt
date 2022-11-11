package com.collathon.librarycnu.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// todo : A collection of commonly used components
/* Common */
@Composable
fun TitleText(contents : String) {
    Text(
        contents,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}

@Composable
fun SubTitleText(contents : String) {
    Text(
        contents,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        color = Color.DarkGray
    )
}

@Composable
fun BlockTitleText(contents : String) {
    Text(
        contents,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center,

    )
}

/* Home */

@Preview
@Composable
fun HomeMenuBlock1(
    //navigateUp: () -> Unit,
) {
    Box(
        modifier = Modifier.padding(5.dp)

    ) {
        Button(
            onClick = { /*TODO*/ },
            //contentPadding = PaddingValues(20.dp),
            modifier = Modifier.width(110.dp)
                .height(110.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, Color.LightGray),
            shape =  RoundedCornerShape(15.dp),
            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = "menu",
                    Modifier.size(35.dp),
                    tint = Color.Black
                )
                SubTitleText(contents = "Message")
                TitleText(contents = "메시지")
            }
        }
    }
}


/* Reservation */

@Composable
fun SeatCellShape() {}

@Composable
fun SeatListShape() {}

@Composable
fun SeatCubeShape() {}