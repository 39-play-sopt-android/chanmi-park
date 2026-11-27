package org.sopt.play.data.datasource.impl.post

import org.sopt.play.data.datasource.api.post.PostDataSource
import org.sopt.play.data.dto.post.CreatePostRequestDto
import org.sopt.play.data.service.PostService
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val postService: PostService,
) : PostDataSource {
    override suspend fun getPosts(
        keyword: String?,
        cursor: Long?,
        size: Int?,
    ) = postService.getPosts(keyword, cursor, size)

    override suspend fun createPost(
        request: CreatePostRequestDto,
    ) = postService.createPost(request)
}
