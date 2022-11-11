package com.collathon.librarycnu.android.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProgressBarAnimated(
    modifier: Modifier,
    color: Color
) {
    var progress by remember { mutableStateOf(0f) }
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    Column(modifier = modifier
    ) {
        Row(modifier = Modifier
            .widthIn(min = 30.dp)
            .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            //Text(text = "$progress")
        }
        // Progress Bar
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
        ){
            // for the background of the ProgressBar
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color.copy(0f))
                .border(2.dp, color, shape = RoundedCornerShape(22.dp))
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 8.dp,
                        bottomStart = 18.dp,
                        bottomEnd = 8.dp))
                    .background(color.copy(0.3f))
                    .animateContentSize()
            )
        }
    }

    LaunchedEffect(key1 = true) {
        progress = 0.7f
    }
}