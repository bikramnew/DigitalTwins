package com.bikram.digitaltwins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bikram.digitaltwins.ui.screens.HomeScreen
import com.bikram.digitaltwins.ui.theme.DigitalTwinsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalTwinsTheme {
                // Home screen with a Scaffold for app
                // bar and bottom navigation tabs
                HomeScreen()
            }
        }
    }
}