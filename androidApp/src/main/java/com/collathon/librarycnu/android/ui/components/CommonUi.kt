package com.collathon.librarycnu.android.ui.components
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.collathon.librarycnu.android.LibScreens
import com.collathon.librarycnu.android.R
import com.collathon.librarycnu.shared.domain.entity.Student
import kotlinx.coroutines.launch

// todo : A collection of commonly used components
/* Common */


@Composable
fun TitleText(contents : String, color : Color) {
    Text(
        contents,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = color,
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
fun BlockTitleText(contents : String) {
    Text(
        contents,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        textAlign = TextAlign.Center,

    )
}

@Composable
fun SubTitleText(contents : String, color : Color = Color.Black) {
    Text(
        contents,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        color = color,
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
            Image(
                IconName,
                contentDescription = "menu",
                Modifier.size(35.dp)
            )
            SubTitleText(contents = subtitleText, Color(0xFF777777))
            TitleText(contents = titleText, Color.Black)
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
            Image(
                IconName,
                contentDescription = "menu",
                Modifier.size(35.dp)
            )
            SubTitleText(contents = subtitleText, Color(0xFF777777))
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
    dest: String,
    theme : List<Color>
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
                StatusBar(theme)
            }
            Row( Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
                ){
                HomeMenuBtnFlat3Row(navController, dest, rightCorners, "상세정보", theme)
                HomeMenuBtnFlat3Row(navController, dest, midCorners, "연장", theme)
                HomeMenuBtnFlat3Row(navController, dest, leftCorners, "반납", theme)

            }
        }
    }
}

@Composable
fun StatusBar(
    theme: List<Color>
) {
    val modifier = Modifier
        .height(78.dp)
        .width(354.dp)
    val colors = listOf(Color(0xFF1771B6), //Color(0xFF0566A3),
        Color(0xFF1874B6), Color(0xFF24B2C2))

    if (theme.get(0) == Color.White) {
        Row(modifier) {
            Row (
                modifier
                    //.padding(5.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // content
                StatusBarWhite(theme)

            }
        }
    }
    else {
        Row(modifier) {
            Row (
                modifier
                    //.padding(5.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .background(brush = Brush.horizontalGradient(colors)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // content
                StatusBarBlue(theme)
            }
        }

    }


}

@Composable
fun StatusBarBlue(
    theme: List<Color>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.44f)
            .fillMaxHeight()
    ) {
        // progress 확인
        ProgressBarAnimated(modifier = Modifier.align(Alignment.Center), color = theme.get(1))
        Row(
            Modifier.align(Alignment.Center),
        ) {
            Icon(
                painterResource(id = R.drawable.ic_round_alarm_24),
                contentDescription = "progressbar",
                tint = theme.get(1),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            // todo : get 학생 정보
            TitleText("120분 남음", theme.get(1))
        }

    }

    val titleText = "2층 제 1열람실 A :168"
    val subtitleText = "배정시간 : 18:51 ~ 22:51"

    StatusBarTextInfo(theme, titleText, subtitleText)
}

@Composable
fun StatusBarWhite(
    theme: List<Color>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.44f)
            .fillMaxHeight()
    ) {
        // progress 확인
        ProgressBarAnimated(modifier = Modifier.align(Alignment.Center), color = Color(0xFF999999))
        Row(
            Modifier.align(Alignment.Center),
        ) {
            Icon(
                painterResource(id = R.drawable.ic_round_calendar_today_24),
                contentDescription = "progressbar",
                tint = theme.get(1),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            // todo : get 학생 정보
            TitleText("D - 20", theme.get(1))
        }

    }

    val titleText = "도서 대출 기록"
    val subtitleText = "대여 기간 : 11/10 ~ 11/20"

    StatusBarTextInfo(theme, titleText, subtitleText)
}


@Composable
fun StatusBarTextInfo(
    theme: List<Color>,
    titleText : String,
    subtitleText : String
) {
    // 열람실 텍스트 정보
    Spacer(modifier = Modifier.width(20.dp))
    Column() {
        TitleText(contents = titleText, theme.get(1))
        Spacer(modifier = Modifier.height(4.dp))
        SubTitleText(contents = subtitleText, theme.get(1))
    }
}

@Preview
@Composable
fun StudentQR(
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
    ) {
        val colors = listOf(Color(0xFF1DA1BB), Color(0xFF0566A3))

        Row(
            modifier = Modifier
                .width(224.dp)
                .height(236.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(
                    brush = Brush.linearGradient(colors)
                )

        ) {
            var isQRMode = remember { mutableStateOf(true) }
            ChangeMode(
                show = isQRMode
            ) {
                isQRMode.value = !isQRMode.value
            }
            //QRMode()
        }
    }

}


@Composable
fun ChangeMode(
    show : MutableState<Boolean>,
    updateVisibility : () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxSize()
            .shadow(0.dp),
        onClick = { updateVisibility()},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent //Color.DarkGray
        ),
        contentPadding = PaddingValues(all=0.dp)
    ) {
        if (show.value) {
            QRMode()
        } else {
            NFCMode()
        }
    }
}

@Preview
@Composable
fun QRMode() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.qr),
            contentDescription = "menu",
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .size(156.dp)
        )
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
@Preview
@Composable
fun NFCMode() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        WaveAnimation()
        ExtraText(text = "N F C", modifier = Modifier.align(Alignment.TopCenter))

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


@Composable
fun ExtraText(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
    )

}


@Composable
fun HomeMenuBtnFlat3Row(
    navController: NavController,
    dest: String,
    cornerShape: Array<Int>, s: String,
    theme: List<Color>      // bgcolor, color, border
) {
    Button(
        onClick = { navController.navigate(dest) },
        modifier = Modifier
            .width(118.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = theme.get(0)),
        border = BorderStroke(0.4.dp, theme.get(2)),
        shape =  RoundedCornerShape(
            topStart = cornerShape.get(0).dp,
            topEnd = cornerShape.get(1).dp,
            bottomStart = cornerShape.get(2).dp,
            bottomEnd = cornerShape.get(3).dp,
        ),
    ) {
        Row(
        ) {
            TitleText(contents = s, theme.get(1))
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
                TitleText(contents = "My Library", Color.Black)
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

