package com.edwardjdp.sensoryapp.navigation

sealed class Screen(val route: String) {
    object SensorCatalog: Screen(route = "sensor_catalog")
    object LightSensor: Screen(route = "light_sensor")
}