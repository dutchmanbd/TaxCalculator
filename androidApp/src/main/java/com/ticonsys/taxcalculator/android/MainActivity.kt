package com.ticonsys.taxcalculator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*

import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ticonsys.taxcalculator.android.home.NavGraphs
import com.ticonsys.taxcalculator.android.home.destinations.HomeScreenDestination


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    navController = navController,
                    startRoute = HomeScreenDestination
                )
            }
        }
    }
}
