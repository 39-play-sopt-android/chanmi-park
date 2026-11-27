package org.sopt.play.data.repository.api.user

interface UserRepository {
    suspend fun getNickname(): String?

    suspend fun setNickname(nickname: String)
}
