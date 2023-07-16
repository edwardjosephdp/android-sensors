package com.edwardjdp.sensoryapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
): ViewModel() {

    var isDark by mutableStateOf(false)
    var isLightSensorOn by mutableStateOf(false)

    fun openLightSensor() {
        lightSensor.startListening()
        isLightSensorOn = true

        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            Log.d("LUX_LVL", lux.toString())
            isDark = lux <= 20f
        }
    }

    fun closeLightSensor() {
        lightSensor.stopListening()
        isLightSensorOn = false
    }
}
