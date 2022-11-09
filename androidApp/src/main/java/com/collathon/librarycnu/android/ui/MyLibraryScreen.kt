package com.collathon.librarycnu.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*
* 학생 개인의 My Library 서비스를 제공하는 ui
* */

@Preview
@Composable
fun MyLibraryScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally

) {
    // todo : fill the body
    Text(text = "Welcome to MyLibraryScreen!")
}