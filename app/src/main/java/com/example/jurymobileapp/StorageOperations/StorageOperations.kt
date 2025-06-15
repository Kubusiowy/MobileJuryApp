package com.example.jurymobileapp.StorageOperations

import androidx.lifecycle.ViewModel

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore(name = "prefs")

class StorageOperations(private val context: Context) {

    companion object {
        val JUROR_ID_KEY = intPreferencesKey("juror_id")
    }

    suspend fun saveJurorId(id: Int) {
        context.dataStore.edit { prefs ->
            prefs[JUROR_ID_KEY] = id
        }
    }

    suspend fun getJurorId(): Int? {
        val prefs = context.dataStore.data.firstOrNull()
        return prefs?.get(JUROR_ID_KEY)
    }

    suspend fun clear() {
        context.dataStore.edit { it.clear() }
    }
}