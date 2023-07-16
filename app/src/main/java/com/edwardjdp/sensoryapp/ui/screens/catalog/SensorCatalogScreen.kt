package com.edwardjdp.sensoryapp.ui.screens.catalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SensorCatalogScreen(
    navigateToLightSensor: () -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxWidth(),
    ) {
        Button(onClick = navigateToLightSensor) {
            Text(text = "Light Sensor")
        }
    }
}
