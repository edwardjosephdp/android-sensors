package com.edwardjdp.sensoryapp.ui.screens.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SensorCatalogScreen(
    navigateToLightSensor: () -> Unit,
    navigateToAccelerometerSensor: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = navigateToLightSensor) {
            Text(text = "Light Sensor")
        }
        Button(onClick = navigateToAccelerometerSensor) {
            Text(text = "Accelerometer Sensor")
        }
    }
}
