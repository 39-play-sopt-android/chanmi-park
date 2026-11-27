package org.sopt.play.data.mapper.post

import org.sopt.play.core.util.toDotDate
import org.sopt.play.data.dto.post.PostDto
import org.sopt.play.data.dto.post.PostListResponseDto
import org.sopt.play.data.model.post.PostListModel
import org.sopt.play.data.model.post.PostModel

fun PostDto.toModel() = PostModel(
    id = id,
    title = title,
    content = content,
    author = author,
    createdAt = createdAt.toDotDate(),
)

fun PostListResponseDto.toModel() = PostListModel(
    posts = posts.map { it.toModel() },
    nextCursor = nextCursor,
    hasNext = hasNext,
)
