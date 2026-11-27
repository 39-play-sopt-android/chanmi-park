package org.sopt.play.data.model.post

data class PostListModel(
    val posts: List<PostModel>,
    val nextCursor: Long?,
    val hasNext: Boolean,
)

data class PostModel(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: String,
)
