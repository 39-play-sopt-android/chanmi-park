package org.sopt.play.presentation.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.post.component.PostCard
import org.sopt.play.presentation.post.component.PostFloatingButton
import org.sopt.play.presentation.post.component.PostSearchTextField
import org.sopt.play.presentation.post.model.dummyPosts

@Composable
fun PostRoute(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PostScreen(
        uiState = uiState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onSearchClick = {},
        onWriteClick = {},
        modifier = modifier,
    )
}

@Composable
private fun PostScreen(
    uiState: PostUiState,
    onSearchQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onWriteClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = PlaySoptTheme.colors.white),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 84.dp),
        ) {
            stickyHeader {
                PostSearchTextField(
                    value = uiState.searchQuery,
                    onValueChange = onSearchQueryChange,
                    onSearchClick = onSearchClick,
                    modifier = Modifier
                        .background(color = PlaySoptTheme.colors.white)
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                )
            }

            items(
                items = uiState.posts,
                key = { it.id },
            ) { post ->
                PostCard(
                    author = post.author,
                    date = post.date,
                    title = post.title,
                    content = post.content,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        PostFloatingButton(
            onClick = onWriteClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 20.dp),
        )
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PlaySoptTheme{
        PostScreen(
            uiState = PostUiState(posts = dummyPosts),
            onSearchQueryChange = {},
            onSearchClick = {},
            onWriteClick = {},
        )
    }
}
