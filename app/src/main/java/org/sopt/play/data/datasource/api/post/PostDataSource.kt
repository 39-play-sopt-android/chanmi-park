package org.sopt.play.data.datasource.api.post

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.post.CreatePostRequestDto
import org.sopt.play.data.dto.post.PostDto
import org.sopt.play.data.dto.post.PostListResponseDto

interface PostDataSource {
    suspend fun getPosts(
        keyword: String?,
        cursor: Long?,
        size: Int?,
    ): BaseResponse<PostListResponseDto>

    suspend fun createPost(
        request: CreatePostRequestDto,
    ): BaseResponse<PostDto>

    suspend fun deletePost(
        postId: Long,
    ): BaseResponse<Unit>
}
