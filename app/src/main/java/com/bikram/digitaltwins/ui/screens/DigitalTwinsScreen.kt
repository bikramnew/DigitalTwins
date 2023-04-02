package com.bikram.digitaltwins.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bikram.digitaltwins.model.MainViewModel

@Composable
fun DigitalTwinsScreen() {
    val viewModel: MainViewModel = viewModel()
    val digitalTwinsList = viewModel.digitalTwinsState

    //todo show the list
}