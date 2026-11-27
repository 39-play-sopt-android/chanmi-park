package org.sopt.play.data.local.datasource.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.sopt.play.data.local.datasource.api.LocalTokenDataSource
import javax.inject.Inject

class LocalTokenDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : LocalTokenDataSource {

    override suspend fun getAuthorizationCode(): String? = dataStore.data
        .map { prefs ->
            prefs[AUTHORIZATION_CODE]
        }.firstOrNull()

    override suspend fun setAuthorizationCode(authorizationCode: String) {
        dataStore.edit { prefs ->
            prefs[AUTHORIZATION_CODE] = authorizationCode
        }
    }

    companion object {
        private val AUTHORIZATION_CODE = stringPreferencesKey("AUTHORIZATION_CODE")
    }
}
