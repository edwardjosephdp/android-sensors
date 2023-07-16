package com.edwardjdp.sensoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.edwardjdp.sensoryapp.navigation.Screen
import com.edwardjdp.sensoryapp.navigation.SetupNavigation
import com.edwardjdp.sensoryapp.ui.theme.AndroidsensorspracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidsensorspracticeTheme {
                val navController = rememberNavController()
                SetupNavigation(
                    startDestination = Screen.SensorCatalog.route,
                    navController = navController
                )
            }
        }
    }
}