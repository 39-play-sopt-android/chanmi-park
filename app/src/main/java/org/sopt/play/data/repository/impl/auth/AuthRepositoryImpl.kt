package org.sopt.play.data.repository.impl.auth

import org.sopt.play.core.util.suspendRunCatching
import org.sopt.play.data.datasource.api.auth.AuthDataSource
import org.sopt.play.data.dto.auth.AuthorizationCodeRequestDto
import org.sopt.play.data.local.TokenStorage
import org.sopt.play.data.repository.api.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val tokenStorage: TokenStorage,
) : AuthRepository {
    override suspend fun issueAuthorizationCode(): Result<Unit> = suspendRunCatching {
        val data = authDataSource.issueAuthorizationCode(
            AuthorizationCodeRequestDto(part = PART),
        ).data ?: throw IllegalStateException("data is null")
        tokenStorage.authorizationCode = data.authorizationCode
    }

    companion object {
        private const val PART = "ANDROID"
    }
}
