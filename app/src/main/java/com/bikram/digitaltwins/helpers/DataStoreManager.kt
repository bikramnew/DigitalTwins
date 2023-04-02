package com.bikram.digitaltwins.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val TWINS_DATASTORE = "twins_datastore"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = TWINS_DATASTORE)

class DataStoreManager(val context: Context) {
    companion object {
        val ACCEPTED = stringPreferencesKey("ACCEPTED")
        val REJECTED = stringPreferencesKey("REJECTED")
    }

    suspend fun saveAcceptedToDataStore(twinDetail: String) {
        context.dataStore.edit {
            it[ACCEPTED] += ",$twinDetail"
        }
    }

    suspend fun saveRejectedToDataStore(twinDetail: String) {
        context.dataStore.edit {
            it[REJECTED] += ",$twinDetail"
        }
    }

    fun getAcceptedFromDataStore(): Flow<String> = context.dataStore.data.map {
        it[ACCEPTED] ?: ""
    }

    fun getRejectedFromDataStore(): Flow<String> = context.dataStore.data.map {
        it[REJECTED] ?: ""
    }

    suspend fun clearDataStore() {
        context.dataStore.edit {
            it[ACCEPTED] = ""
            it[REJECTED] = ""
        }
    }
}