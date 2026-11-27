package org.sopt.play.presentation.post

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.play.data.model.post.PostModel

data class PostUiState(
    val searchQuery: String = "",
    val posts: ImmutableList<PostModel> = persistentListOf(),
    val isBottomSheetVisible: Boolean = false,
    val title: String = "",
    val content: String = "",
    val deletePostId: Long? = null,
)
