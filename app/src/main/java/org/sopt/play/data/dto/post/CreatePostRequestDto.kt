package org.sopt.play.data.dto.post

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatePostRequestDto(
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("author") val author: String,
)
