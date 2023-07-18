package com.edwardjdp.sensoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edwardjdp.sensoryapp.MainViewModel
import com.edwardjdp.sensoryapp.ui.screens.accelerometer.AccelerometerSensorScreen
import com.edwardjdp.sensoryapp.ui.screens.catalog.SensorCatalogScreen
import com.edwardjdp.sensoryapp.ui.screens.gyroscope.GyroscopeSensorScreen
import com.edwardjdp.sensoryapp.ui.screens.light.LightSensorScreen

@Composable
fun SetupNavigation(
    startDestination: String,
    navController: NavHostController,
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        sensorCatalogRoute(
            navigateToLightSensor = {
                navController.navigate(Screen.LightSensor.route)
            },
            navigateToAccelerometerSensor = {
                navController.navigate(Screen.AccelerometerSensor.route)
            },
            navigateToGyroscopeSensor = {
                navController.navigate(Screen.GyroscopeSensor.route)
            }
        )
        lightSensorRoute(
            onBackPressed = {
                navController.popBackStack()
                navController.navigate(Screen.SensorCatalog.route)
            }
        )
        accelerometerSensorRoute(
            onBackPressed = {
                navController.popBackStack()
                navController.navigate(Screen.SensorCatalog.route)
            }
        )
        gyroscopeSensorRoute (
            onBackPressed = {
                navController.popBackStack()
                navController.navigate(Screen.SensorCatalog.route)
            }
        )
    }
}

fun NavGraphBuilder.sensorCatalogRoute(
    navigateToLightSensor: () -> Unit,
    navigateToAccelerometerSensor: () -> Unit,
    navigateToGyroscopeSensor: () -> Unit,
) {
    composable(route = Screen.SensorCatalog.route) {
        SensorCatalogScreen(
            navigateToLightSensor = navigateToLightSensor,
            navigateToAccelerometerSensor = navigateToAccelerometerSensor,
            navigateToGyroscopeSensor = navigateToGyroscopeSensor,
        )
    }
}

fun NavGraphBuilder.lightSensorRoute(
    onBackPressed: () -> Unit,
) {
    composable(route = Screen.LightSensor.route) {
        val viewModel: MainViewModel = hiltViewModel()
        LightSensorScreen(
            isDark = viewModel.isDark,
            isSensorOn = viewModel.isLightSensorOn,
            onBackPressed = {
                viewModel.closeLightSensor()
                onBackPressed()
            },
            openLightSensor = viewModel::openLightSensor,
            closeLightSensor = viewModel::closeLightSensor
        )
    }
}

fun NavGraphBuilder.accelerometerSensorRoute(
    onBackPressed: () -> Unit,
) {
    composable(route = Screen.AccelerometerSensor.route) {
        val viewModel: MainViewModel = hiltViewModel()
        AccelerometerSensorScreen(
            isShaking = viewModel.isShaking,
            onBackPressed = {
                viewModel.closeAccelerometerSensor()
                onBackPressed()
            },
            openAccelerometerSensor = viewModel::openAccelerometerSensor,
            closeAccelerometerSensor = viewModel::closeAccelerometerSensor
        )
    }
}

fun NavGraphBuilder.gyroscopeSensorRoute(
    onBackPressed: () -> Unit,
) {
    composable(route = Screen.GyroscopeSensor.route) {
        val viewModel: MainViewModel = hiltViewModel()
        GyroscopeSensorScreen(
            isRotating = viewModel.isRotating,
            onBackPressed = {
                viewModel.closeGyroscopeSensor()
                onBackPressed()
            },
            openGyroscopeSensor = viewModel::openGyroscopeSensor,
            closeGyroscopeSensor = viewModel::closeGyroscopeSensor
        )
    }
}
