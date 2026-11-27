package org.sopt.play.data.datasource.api.auth

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.auth.AuthorizationCodeRequestDto
import org.sopt.play.data.dto.auth.AuthorizationCodeResponseDto

interface AuthDataSource {
    suspend fun issueAuthorizationCode(
        request: AuthorizationCodeRequestDto,
    ): BaseResponse<AuthorizationCodeResponseDto>
}
