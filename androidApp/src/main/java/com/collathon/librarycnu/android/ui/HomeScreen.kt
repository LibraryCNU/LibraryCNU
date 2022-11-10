package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.collathon.librarycnu.android.LibScreens
import com.collathon.librarycnu.android.ui.components.*

//todo : fill the composables

@Composable
fun HomeScreen(                 // 여기서 Body 부분 코딩
    modifier: Modifier = Modifier
        .background(Color(0xFFE7EAF0))
        .fillMaxSize(),
    navController: NavController,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
) {
    Column(modifier = modifier) {
        val modifierRow = Modifier
            .fillMaxWidth()
        val dest1 = LibScreens.BookService.title
        val dest2 = LibScreens.Home.title

        StudentInfoBar(modifierRow)
        MyLibraryBar(navController, modifierRow)

        FirstRowField(navController, modifierRow)
        SecondRowField(navController, dest2, modifierRow)
        SecondRowField(navController, dest1, modifierRow)
        ThirdRowField(navController, modifierRow)
    }
}



@Composable
fun StudentInfoBar(modifier: Modifier) {
    Row (modifier) {
        Box(
            modifier
                .padding(horizontal = 30.dp, vertical = 15.dp)
        ) {
            StudentInfoField(Modifier.align(Alignment.TopStart))
            StudentStatusBar(Modifier.align(Alignment.TopEnd))
        }
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
    modifier: Modifier
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        HomeMenuBlock3Row(navController, dest)
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
