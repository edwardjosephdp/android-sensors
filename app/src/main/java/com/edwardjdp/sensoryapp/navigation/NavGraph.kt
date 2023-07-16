package com.edwardjdp.sensoryapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edwardjdp.sensoryapp.MainViewModel
import com.edwardjdp.sensoryapp.ui.screens.catalog.SensorCatalogScreen
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
            }
        )
        lightSensorRoute(
            onBackPressed = {
                navController.popBackStack()
                navController.navigate(Screen.SensorCatalog.route)
            }
        )
    }
}

fun NavGraphBuilder.sensorCatalogRoute(
    navigateToLightSensor: () -> Unit,
) {
    composable(route = Screen.SensorCatalog.route) {
        SensorCatalogScreen(
            navigateToLightSensor = navigateToLightSensor
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