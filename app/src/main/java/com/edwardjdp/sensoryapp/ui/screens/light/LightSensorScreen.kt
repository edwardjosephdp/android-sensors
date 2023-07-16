package com.edwardjdp.sensoryapp.ui.screens.light

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
fun LightSensorScreen(
    isDark: Boolean,
    isSensorOn: Boolean,
    onBackPressed: () -> Unit,
    openLightSensor: () -> Unit,
    closeLightSensor: () -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        openLightSensor()
    }

    BackPressHandler(
        onBackPressed = {
            closeLightSensor()
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
                    if (isDark) Color.DarkGray else Color.White
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isDark) "It is dark outside" else "It is bright outside",
                color = if (isDark) Color.White else Color.Black
            )
        }
        Button(onClick = {}) {
            Text(text = if (isSensorOn) "Close Light Sensor" else "Open Light Sensor")
        }
    }
}
