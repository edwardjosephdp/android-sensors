package com.edwardjdp.sensoryapp.ui.screens.accelerometer

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
fun AccelerometerSensorScreen(
    isShaking: Boolean,
    onBackPressed: () -> Unit,
    openAccelerometerSensor: () -> Unit,
    closeAccelerometerSensor: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        openAccelerometerSensor()
    }

    BackPressHandler(
        onBackPressed = {
            closeAccelerometerSensor()
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
                    if (isShaking) Color.Yellow else Color.White
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isShaking) "Ohh yeah! I'm dancing!" else "Shake it so I'll dance.",
                color = Color.Black
            )
        }
        Button(onClick = {}) {
            Text(text = if (isShaking) "Close Light Sensor" else "Open Light Sensor")
        }
    }
}