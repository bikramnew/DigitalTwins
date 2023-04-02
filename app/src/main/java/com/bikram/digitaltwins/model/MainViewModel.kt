package com.bikram.digitaltwins.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bikram.digitaltwins.helpers.DataStoreManager

class MainViewModel(val dataStoreManager: DataStoreManager) : ViewModel() {
    var digitalTwinsState: SnapshotStateList<DigitalTwin> = mutableStateListOf(DigitalTwin())

    init {
        digitalTwinsState = SnapshotStateList<DigitalTwin>();
        digitalTwins.forEach { digitalTwin ->
            digitalTwinsState.add(digitalTwin)
        }
    }

    suspend fun saveAcceptedToDataStore(twinId: String?) {
        dataStoreManager.saveAcceptedToDataStore(twinId!!)
    }

    suspend fun saveRejectedToDataStore(twinId: String?) {
        dataStoreManager.saveRejectedToDataStore(twinId!!)
    }
}

class MainViewModelFactory(val dataStoreManager: DataStoreManager) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(dataStoreManager) as T
}