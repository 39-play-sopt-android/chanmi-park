package org.sopt.play.data.repository.impl.user

import org.sopt.play.data.local.datasource.api.LocalUserDataSource
import org.sopt.play.data.repository.api.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localUserDataSource: LocalUserDataSource,
) : UserRepository {
    override suspend fun getNickname(): String? = localUserDataSource.getNickname()

    override suspend fun setNickname(nickname: String) {
        localUserDataSource.setNickname(nickname)
    }
}
