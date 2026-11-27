package org.sopt.play.data.repository.api.post

import org.sopt.play.data.model.post.PostListModel

interface PostRepository {
    suspend fun getPosts(
        keyword: String?,
        cursor: Long?,
        size: Int?,
    ): Result<PostListModel>
}
