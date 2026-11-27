package org.sopt.play.data.dto.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationCodeRequestDto(
    @SerialName("part") val part: String,
)

@Serializable
data class AuthorizationCodeResponseDto(
    @SerialName("authorizationCode") val authorizationCode: String,
)
