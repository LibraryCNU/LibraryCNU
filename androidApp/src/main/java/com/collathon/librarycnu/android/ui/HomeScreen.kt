package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.collathon.librarycnu.android.ui.HomeScreen
import com.collathon.librarycnu.android.ui.components.HomeMenuBlock1

//todo : fill the composables


@Preview
@Composable
fun HomeScreen(                 // 여기서 Body 부분 코딩
    modifier: Modifier = Modifier.fillMaxSize(),
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        BlockRow()
        BlockRow()
        BlockRow()
        BlockRow()
    }
}

@Composable
fun BlockRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center

    ) {
        HomeMenuBlock1()
        HomeMenuBlock1()
        HomeMenuBlock1()

    }
}
