package com.collathon.librarycnu.android.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.collathon.librarycnu.android.LibScreens
import com.collathon.librarycnu.android.R

// todo : A collection of commonly used components
/* Common */


@Composable
fun TitleText(contents : String) {
    Text(
        contents,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        letterSpacing = -0.5.sp
    )
}

@Composable
fun TitleNarrowText(contents : String) {
    Text(
        contents,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        letterSpacing = -1.sp
    )
}


@Composable
fun SubTitleText(contents : String) {
    Text(
        contents,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xFF777777),
        letterSpacing = -0.3.sp
    )
}


/* Home */

@Composable
fun HomeBtn(
    navController : NavController,
    dest : String,
    cornerShape: Array<Int>,
    width: Int, height: Int,
    bgcolor: Color,
    titleText: String, subtitleText: String,
    IconName: Painter
){
    Button(
        onClick = { navController.navigate(dest) },
        //contentPadding = PaddingValues(20.dp),
        modifier = Modifier
            .width(width.dp)
            .height(height.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = bgcolor),
        border = BorderStroke(0.4.dp, Color.LightGray),
        shape =  RoundedCornerShape(
            topStart = cornerShape.get(0).dp,
            topEnd = cornerShape.get(1).dp,
            bottomStart = cornerShape.get(2).dp,
            bottomEnd = cornerShape.get(3).dp,
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                IconName,
                contentDescription = "menu",
                Modifier.size(35.dp)
            )
            SubTitleText(contents = subtitleText)
            TitleText(contents = titleText)
        }
    }
}


@Composable
fun HomeNarrowBtn(
    navController: NavController,
    dest : String,
    cornerShape: Array<Int>,
    width: Int, height: Int,
    bgcolor: Color,
    titleText: String, subtitleText: String,
    IconName: Painter
){
    Button(
        onClick = { navController.navigate(dest)},
        //contentPadding = PaddingValues(20.dp),
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = bgcolor),
        border = BorderStroke(0.4.dp, Color.LightGray),
        shape =  RoundedCornerShape(
            topStart = cornerShape.get(0).dp,
            topEnd = cornerShape.get(1).dp,
            bottomStart = cornerShape.get(2).dp,
            bottomEnd = cornerShape.get(3).dp,
        ),
    ) {
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                IconName,
                contentDescription = "menu",
                Modifier.size(35.dp)
            )
            SubTitleText(contents = subtitleText)
            TitleNarrowText(contents = titleText)
        }
    }
}


@Composable
fun HomeMenuBlock1(
    navController: NavController,
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        // topStart, topEnd, bottomEnd, bottomStart
        val corners: Array<Int> = arrayOf(15, 15, 15, 15)
        var dest = LibScreens.Home.title

        HomeBtn(navController, dest, corners,114, 114, Color.White,
            "App 등록", "Device", painterResource(id = R.drawable.ic_round_phonelink_ring_24))
    }
}

@Composable
fun HomeMenuBlock2Row(
    navController: NavController,
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Row() {
            val rightCorners: Array<Int> = arrayOf(15, 0, 15, 0)
            val leftCorners: Array<Int> = arrayOf(0, 15, 0, 15)
            val dest1 = LibScreens.Home.title
            val dest2 = LibScreens.Home.title

            HomeBtn(navController, dest1, rightCorners,114, 112, Color.White,
                "배정현황", "status", painterResource(id = R.drawable.ic_round_access_time_24))
            HomeBtn(navController, dest2, leftCorners, 114, 112, Color.White,
                "메시지", "message", painterResource(id = R.drawable.ic_outline_email_24))
        }
    }
}

@Composable
fun HomeMenuBlock2Col(navController: NavController) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Column() {
            var upCorners: Array<Int> = arrayOf(15, 15, 0, 0)
            var downCorners: Array<Int> = arrayOf(0, 0, 15, 15)
            var dest1 = LibScreens.ReserveSeat.title
            var dest2 = LibScreens.ReserveSeat.title
            HomeBtn(navController, dest1, upCorners,114, 118, Color.White,
                "열람좌석", "reservation", painterResource(id = R.drawable.ic_reserv_seat))
            HomeNarrowBtn(navController, dest2, downCorners, 114, 118, Color.White,
                "크리에이티브룸", "creative room", painterResource(id = R.drawable.ic_creative_room))
        }
    }
}

@Composable
fun HomeMenuBlock3Row(
    navController:NavController,
    dest: String
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,

        ) {
            var rightCorners: Array<Int> = arrayOf(0, 0, 15, 0)
            var midCorners: Array<Int> = arrayOf(0, 0, 0, 0)
            var leftCorners: Array<Int> = arrayOf(0, 0, 0, 15)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center)
            {
                StatusBar()
            }
            Row( Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
                ){
                HomeMenuBtnFlat3Row(navController, dest, rightCorners, "상세정보")
                HomeMenuBtnFlat3Row(navController, dest, midCorners, "연장")
                HomeMenuBtnFlat3Row(navController, dest, leftCorners, "반납")

            }
        }
    }
}
@Composable
fun StatusBar() {
    Row(Modifier
        .height(78.dp)
        .width(354.dp)
        .background(color = Color.Red)) {
        Text(text = "야호")
    }
}

@Composable
fun StudentQR(
    //navigateUp: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
    ) {
        val colors = listOf(Color(0xFF1DA1BB), Color(0xFF0566A3) )
        Row(
            modifier = Modifier
                .width(224.dp)
                .height(236.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = colors,
                        start = Offset.Zero,
                        end = Offset.Infinite
                    ),
                )
            //.border(shape = RoundedCornerShape(5.dp))
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Text(text = "QR 자리", Modifier.align(Alignment.Center))
                ExtraText(text = "C N U", modifier = Modifier.align(Alignment.TopCenter))
                BracketTopStart(Modifier.align(Alignment.TopStart) )
                BracketTopStart(
                    Modifier
                        .align(Alignment.TopEnd)
                        .rotate(90f))
                BracketTopStart(
                    Modifier
                        .align(Alignment.BottomStart)
                        .rotate(270f))
                BracketTopStart(
                    Modifier
                        .align(Alignment.BottomEnd)
                        .rotate(180f))
            }
        }
    }
}


@Composable
fun ExtraText(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
    )

}

@Composable
fun HomeMenuBtnFlat3Row(
    navController: NavController,
    dest: String,
    cornerShape: Array<Int>, s: String) {
    Button(
        onClick = { navController.navigate(dest) },
        modifier = Modifier
            .width(118.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        border = BorderStroke(0.4.dp, Color.LightGray),
        shape =  RoundedCornerShape(
            topStart = cornerShape.get(0).dp,
            topEnd = cornerShape.get(1).dp,
            bottomStart = cornerShape.get(2).dp,
            bottomEnd = cornerShape.get(3).dp,
        ),
    ) {
        Row(
        ) {
            TitleText(contents = s)
        }
    }
}

@Composable
fun HomeMenuBlockFlat(navController: NavController) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Button(
            onClick = { navController.navigate(LibScreens.MyLibrary.title) },
            modifier = Modifier
                .width(352.dp)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(0.4.dp, Color.LightGray),
            shape =  RoundedCornerShape(10.dp),
        ) {
            Row(
            ) {
                TitleText(contents = "My Library")
            }
        }

    }
}

@Composable
fun BracketTopStart(modifier: Modifier) {
    Canvas(
        modifier
            .size(50.dp)
            .padding(10.dp)
    ) {
        var color = Color.White
        var size = Size(20f, 80f)
        var corner = CornerRadius(60f, 60f)

        rotate(degrees = 90F) {
            drawRoundRect( color = color, size = size, cornerRadius = corner)
        }
        drawRoundRect(color = color,  size = Size(20f, 70f), cornerRadius = corner)
    }
}


// todo : student info import
@Composable
fun StudentInfoField( modifier: Modifier ) {
    Column(modifier) {
        TitleText(contents = "김충남")
        Spacer(modifier = Modifier.height(2.dp))
        SubTitleText(contents = "202002488")
        Spacer(modifier = Modifier.height(2.dp))
        SubTitleText(contents = "공과대학 컴퓨터융합학부")
    }
}


@Composable
fun StudentStatusBar( modifier: Modifier ) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 0.dp,
        backgroundColor = Color(0xFFE7EAF0),
        modifier = modifier,
        border = BorderStroke(0.4.dp, Color.LightGray),
    )
    {
        Text(text = "재학중",
            modifier = Modifier.padding(horizontal = 22.dp, vertical = 8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF777777))
    }
}