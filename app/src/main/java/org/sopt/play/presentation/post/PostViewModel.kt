package org.sopt.play.presentation.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.play.data.repository.api.post.PostRepository
import org.sopt.play.data.repository.api.user.UserRepository
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PostUiState())
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    init {
        getPosts()
    }

    fun onSearchQueryChange(searchQuery: String) {
        _uiState.update { it.copy(searchQuery = searchQuery) }
    }

    fun onWriteClick() {
        _uiState.update { it.copy(isBottomSheetVisible = true) }
    }

    fun onTitleChange(title: String) {
        _uiState.update { it.copy(title = title) }
    }

    fun onContentChange(content: String) {
        _uiState.update { it.copy(content = content) }
    }

    fun onBottomSheetDismiss() {
        _uiState.update {
            it.copy(
                isBottomSheetVisible = false,
                title = "",
                content = "",
            )
        }
    }

    fun createPost(
        onFailure: (String) -> Unit,
    ) {
        val state = _uiState.value
        onBottomSheetDismiss()

        viewModelScope.launch {
            postRepository.createPost(
                title = state.title,
                content = state.content,
                author = userRepository.getNickname().orEmpty(),
            )
                .onSuccess { getPosts() }
                .onFailure { onFailure(it.message.orEmpty()) }
        }
    }

    fun onPostLongClick(postId: Long) {
        _uiState.update { it.copy(deletePostId = postId) }
    }

    fun onDeleteModalDismiss() {
        _uiState.update { it.copy(deletePostId = null) }
    }

    fun deletePost(
        onFailure: (String) -> Unit,
    ) {
        val postId = _uiState.value.deletePostId ?: return
        onDeleteModalDismiss()

        viewModelScope.launch {
            postRepository.deletePost(postId)
                .onSuccess { getPosts() }
                .onFailure { onFailure(it.message.orEmpty()) }
        }
    }

    private fun getPosts() {
        viewModelScope.launch {
            postRepository.getPosts(keyword = null, cursor = null, size = null)
                .onSuccess { postList ->
                    _uiState.update { state ->
                        state.copy(posts = postList.posts.toImmutableList())
                    }
                }
                .onFailure { Log.e("PostViewModel", "getPosts failed", it) }
        }
    }
}
