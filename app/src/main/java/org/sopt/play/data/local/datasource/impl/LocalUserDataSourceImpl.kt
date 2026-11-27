package org.sopt.play.data.local.datasource.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.sopt.play.data.local.datasource.api.LocalUserDataSource
import javax.inject.Inject

class LocalUserDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : LocalUserDataSource {

    override suspend fun getNickname(): String? = dataStore.data
        .map { prefs ->
            prefs[NICKNAME]
        }.firstOrNull()

    override suspend fun setNickname(nickname: String) {
        dataStore.edit { prefs ->
            prefs[NICKNAME] = nickname
        }
    }

    companion object {
        private val NICKNAME = stringPreferencesKey("NICKNAME")
    }
}
