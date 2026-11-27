package org.sopt.play.data.local.datasource.api

interface LocalTokenDataSource {
    suspend fun getAuthorizationCode(): String?

    suspend fun setAuthorizationCode(authorizationCode: String)
}
