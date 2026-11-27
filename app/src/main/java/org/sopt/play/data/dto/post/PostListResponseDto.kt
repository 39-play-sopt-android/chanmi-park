package org.sopt.play.data.dto.post

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostListResponseDto(
    @SerialName("posts") val posts: List<PostDto>,
    @SerialName("nextCursor") val nextCursor: Long? = null,
    @SerialName("hasNext") val hasNext: Boolean,
)

@Serializable
data class PostDto(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("author") val author: String,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("updatedAt") val updatedAt: String,
)
