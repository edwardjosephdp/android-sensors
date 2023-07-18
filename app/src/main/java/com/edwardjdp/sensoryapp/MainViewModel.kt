package com.edwardjdp.sensoryapp

import android.hardware.SensorManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.sqrt


@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: LightSensor,
    private val accelerometerSensor: AccelerometerSensor,
    private val gyroscopeSensor: GyroscopeSensor,
): ViewModel() {

    var isDark by mutableStateOf(false)
    var isLightSensorOn by mutableStateOf(false)

    var isShaking by mutableStateOf(false)
    private var acceleration by mutableStateOf(0f)
    private var currentAcceleration by mutableStateOf(0f)
    private var lastAcceleration by mutableStateOf(0f)

    var isRotating by mutableStateOf(Pair(false, 0))

    fun openLightSensor() {
        lightSensor.startListening()
        isLightSensorOn = true

        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            isDark = lux <= 20f
        }
    }

    fun closeLightSensor() {
        lightSensor.stopListening()
        isLightSensorOn = false
    }

    fun openAccelerometerSensor() {
        acceleration = 10f
        currentAcceleration = SensorManager.GRAVITY_EARTH
        lastAcceleration = SensorManager.GRAVITY_EARTH

        accelerometerSensor.startListening()
        accelerometerSensor.setOnSensorValuesChangedListener { values ->
            val xValue = abs(values[0])
            val yValue = abs(values[1])
            val zValue = abs(values[2])

            lastAcceleration = currentAcceleration
            currentAcceleration = sqrt(xValue * xValue + yValue * yValue + zValue * zValue)
            val delta = currentAcceleration - lastAcceleration
            acceleration = acceleration * 0.9f + delta
            if (acceleration > 10) {
                isShaking = true
            } else {
                viewModelScope.launch {
                    delay(3000)
                    isShaking = false
                }
            }
        }
    }

    fun closeAccelerometerSensor() {
        accelerometerSensor.stopListening()
    }

    fun openGyroscopeSensor() {
        gyroscopeSensor.startListening()
        gyroscopeSensor.setOnSensorValuesChangedListener { values ->
            isRotating = if (values[2] > 0.5f) {
                Pair(true, -1)
            } else if (values[2] < -0.5f) {
                Pair(true, 1)
            } else {
                Pair(false, 0)
            }
        }
    }

    fun closeGyroscopeSensor() {
        gyroscopeSensor.stopListening()
    }
}
