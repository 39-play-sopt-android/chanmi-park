package org.sopt.play.data.local.datasource.api

interface LocalUserDataSource {
    suspend fun getNickname(): String?

    suspend fun setNickname(nickname: String)
}
