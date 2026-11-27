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
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(PostUiState())
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    init {
        getPosts()
    }

    fun onSearchQueryChange(searchQuery: String) {
        _uiState.update { it.copy(searchQuery = searchQuery) }
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
