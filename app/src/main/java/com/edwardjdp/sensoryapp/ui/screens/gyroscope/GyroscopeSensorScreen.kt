package com.edwardjdp.sensoryapp.ui.screens.gyroscope

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.edwardjdp.sensoryapp.util.BackPressHandler

@Composable
fun GyroscopeSensorScreen(
    isRotating: Pair<Boolean, Int>,
    onBackPressed: () -> Unit,
    openGyroscopeSensor: () -> Unit,
    closeGyroscopeSensor: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        openGyroscopeSensor()
    }

    BackPressHandler(
        onBackPressed = {
            closeGyroscopeSensor()
            onBackPressed()
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (isRotating.first) {
                        if (isRotating.second == -1) {
                            Color.Yellow
                        } else {
                            Color.Green
                        }
                    } else {
                        Color.White
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isRotating.first) {
                    if (isRotating.second == -1) {
                        "Rotating counter-clockwise"
                    } else {
                        "Rotating clockwise"
                    }
                } else {
                    "I'm just steady"
                }
            )
        }
        Button(onClick = {}) {
            Text(text = if (isRotating.first) "Close Gyroscope Sensor" else "Open Gyroscope Sensor")
        }
    }
}
