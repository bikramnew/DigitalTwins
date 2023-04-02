package com.bikram.digitaltwins.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {
    var digitalTwinsState: SnapshotStateList<DigitalTwin> = mutableStateListOf(DigitalTwin())

    init {
        digitalTwinsState = SnapshotStateList<DigitalTwin>();
        digitalTwins.forEach { digitalTwin ->
            digitalTwinsState.add(digitalTwin)
        }
    }
}