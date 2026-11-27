package org.sopt.play.data.repository.api.auth

interface AuthRepository {
    suspend fun issueAuthorizationCode(): Result<Unit>
}
