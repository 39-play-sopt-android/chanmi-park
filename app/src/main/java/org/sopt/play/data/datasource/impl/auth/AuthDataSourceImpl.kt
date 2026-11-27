package org.sopt.play.data.datasource.impl.auth

import org.sopt.play.data.datasource.api.auth.AuthDataSource
import org.sopt.play.data.dto.auth.AuthorizationCodeRequestDto
import org.sopt.play.data.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService,
) : AuthDataSource {
    override suspend fun issueAuthorizationCode(
        request: AuthorizationCodeRequestDto,
    ) = authService.issueAuthorizationCode(request)
}
