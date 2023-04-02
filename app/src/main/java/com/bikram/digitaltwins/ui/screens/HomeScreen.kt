package com.bikram.digitaltwins.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bikram.digitaltwins.helpers.DataStoreManager
import com.bikram.digitaltwins.ui.components.CustomAppBar
import com.bikram.digitaltwins.ui.components.CustomBottomBar
import com.bikram.digitaltwins.ui.theme.colorPrimary
import com.bikram.digitaltwins.ui.theme.ghost_white

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    val selectedIndex = remember { mutableStateOf(0) }

    val dataStoreManager = DataStoreManager(LocalContext.current)
    val acceptedTwins = dataStoreManager.getAcceptedFromDataStore().collectAsState(initial = "")
    val rejectedTwins = dataStoreManager.getRejectedFromDataStore().collectAsState(initial = "")

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomAppBar()
            },
            content = {
                Surface(modifier = Modifier.fillMaxSize(), color = colorPrimary) {
                    Card(
                        backgroundColor = ghost_white,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Box(modifier = Modifier.padding(bottom = 100.dp)) {
                            when (selectedIndex.value) {
                                0 -> {
                                    DigitalTwinsScreen(
                                        acceptedTwins.value,
                                        rejectedTwins.value
                                    )
                                }
                                1 -> {
                                    //make item non swipeable and only
                                    //show accepted twins in this tab
                                    DigitalTwinsScreen(
                                        acceptedTwins.value,
                                        rejectedTwins.value,
                                        false,
                                        true
                                    )
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                CustomBottomBar(selectedIndex = selectedIndex)
            },
        )
    }
}