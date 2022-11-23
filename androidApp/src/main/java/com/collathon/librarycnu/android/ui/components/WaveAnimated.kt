package com.collathon.librarycnu.android.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Preview
@Composable
fun TEMP() {
    Box(
        Modifier
            .size(500.dp)
            .background(Color.Green)
    ) {
        WaveAnimation()
    }

}

@Composable
fun WaveAnimation(
) {
    val circleColor : Color = Color.White
    val animationDelay = 2000

    // 3 circles
    val circles = listOf(
        remember {
            Animatable(initialValue = 0f)
        },
        remember {
            Animatable(initialValue = 0f)
        },
        remember {
            Animatable(initialValue = 0f)
        }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            // Use coroutine delay to sync animations
            // divide the animation delay by number of circles
            delay(timeMillis = (animationDelay / 3L) * (index + 1))

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = animationDelay,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // outer circle
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .size(size = 200.dp)
                .background(color = Color.Transparent),

        ) {
            // animating circles
            circles.forEachIndexed { index, animatable ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .scale(scale = animatable.value)
                        .size(size = 200.dp)
                        .clip(shape = CircleShape)
                        .background(
                            color = circleColor
                                .copy(alpha = (1 - animatable.value))
                        )
                ) {
                }
            }
        }

    }
}