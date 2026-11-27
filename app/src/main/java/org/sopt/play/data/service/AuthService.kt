package org.sopt.play.data.service

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.auth.AuthorizationCodeRequestDto
import org.sopt.play.data.dto.auth.AuthorizationCodeResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("api/v1/members/authorization-code")
    suspend fun issueAuthorizationCode(
        @Body request: AuthorizationCodeRequestDto,
    ): BaseResponse<AuthorizationCodeResponseDto>
}
