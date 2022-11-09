package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*
* 도서 서비스를 전체적으로 담당하는 ui
* */

@Preview
@Composable
fun BookServiceScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally

) {
    // todo : fill the body
    Text(text = "Welcome to BookServiceScreen!")
}