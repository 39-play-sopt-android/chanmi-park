package org.sopt.play.data.repository.impl.post

import org.sopt.play.core.util.suspendRunCatching
import org.sopt.play.data.mapper.post.toModel
import org.sopt.play.data.model.post.PostListModel
import org.sopt.play.data.datasource.api.post.PostDataSource
import org.sopt.play.data.dto.post.CreatePostRequestDto
import org.sopt.play.data.repository.api.post.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource,
) : PostRepository {
    override suspend fun getPosts(
        keyword: String?,
        cursor: Long?,
        size: Int?,
    ): Result<PostListModel> = suspendRunCatching {
        val data = postDataSource.getPosts(keyword, cursor, size).data
            ?: throw IllegalStateException("data is null")
        data.toModel()
    }

    override suspend fun createPost(
        title: String,
        content: String,
        author: String,
    ): Result<Unit> = suspendRunCatching {
        postDataSource.createPost(
            CreatePostRequestDto(
                title = title,
                content = content,
                author = author,
            ),
        )
    }

    override suspend fun deletePost(
        postId: Long,
    ): Result<Unit> = suspendRunCatching {
        postDataSource.deletePost(postId)
    }
}
