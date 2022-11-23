package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.collathon.librarycnu.android.LibScreens
import com.collathon.librarycnu.android.ui.components.*
import com.collathon.librarycnu.shared.SDKForAndroid

//todo : fill the composables

@Composable
fun HomeScreen(                 // 여기서 Body 부분 코딩
    modifier: Modifier = Modifier
        .background(Color(0xFFE7EAF0))
        .fillMaxSize(),
    navController: NavController,
    sdk : SDKForAndroid,
    //verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    //horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
) {
    Column(modifier = modifier) {
        val modifierRow = Modifier
            .fillMaxWidth()
        val dest1 = LibScreens.BookService.title
        val dest2 = LibScreens.ReserveSeat.title
        val blue_theme = listOf<Color>(Color(0xFF27608B), Color.White, Color.White)
        val white_theme = listOf<Color>(Color.White, Color.Black, Color.LightGray)

        StudentInfoBar(modifierRow, sdk)
        MyLibraryBar(navController, modifierRow)

        FirstRowField(navController, modifierRow)
        SecondRowField(navController, dest2, modifierRow, blue_theme)
        SecondRowField(navController, dest1, modifierRow, white_theme)
        ThirdRowField(navController, modifierRow)
    }
}




@Composable
fun MyLibraryBar(navController: NavController, modifier: Modifier) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        HomeMenuBlockFlat(navController)
    }
}

@Composable
fun FirstRowField(navController: NavController, modifier: Modifier) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        HomeMenuBlock2Col(navController)
        StudentQR()
    }
}

@Composable
fun SecondRowField(
    navController: NavController,
    dest : String,
    modifier: Modifier,
    theme : List<Color>
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        HomeMenuBlock3Row(navController, dest, theme)
    }
}

@Composable
fun ThirdRowField(
    navController: NavController,
    modifier : Modifier) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        HomeMenuBlock2Row(navController)
        HomeMenuBlock1(navController)
    }
}
