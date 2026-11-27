package org.sopt.play.data.service

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.post.PostListResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PostService {
    @GET("api/v1/posts")
    suspend fun getPosts(
        @Query("keyword") keyword: String? = null,
        @Query("cursor") cursor: Long? = null,
        @Query("size") size: Int? = null,
    ): BaseResponse<PostListResponseDto>
}
