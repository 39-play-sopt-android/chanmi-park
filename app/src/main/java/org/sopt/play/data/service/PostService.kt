package org.sopt.play.data.service

import org.sopt.play.data.dto.BaseResponse
import org.sopt.play.data.dto.post.CreatePostRequestDto
import org.sopt.play.data.dto.post.PostDto
import org.sopt.play.data.dto.post.PostListResponseDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {
    @GET("api/v1/posts")
    suspend fun getPosts(
        @Query("keyword") keyword: String? = null,
        @Query("cursor") cursor: Long? = null,
        @Query("size") size: Int? = null,
    ): BaseResponse<PostListResponseDto>

    @POST("api/v1/posts")
    suspend fun createPost(
        @Body request: CreatePostRequestDto,
    ): BaseResponse<PostDto>

    @DELETE("api/v1/posts/{postId}")
    suspend fun deletePost(
        @Path("postId") postId: Long,
    ): BaseResponse<Unit>
}
