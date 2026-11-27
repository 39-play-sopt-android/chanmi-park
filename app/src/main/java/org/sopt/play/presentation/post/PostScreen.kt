package org.sopt.play.presentation.post

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.data.model.post.PostModel
import org.sopt.play.presentation.post.component.PostBottomSheet
import org.sopt.play.presentation.post.component.PostCard
import org.sopt.play.presentation.post.component.PostFloatingButton
import org.sopt.play.presentation.post.component.PostSearchTextField

@Composable
fun PostRoute(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PostScreen(
        uiState = uiState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onSearchClick = {},
        onWriteClick = viewModel::onWriteClick,
        onTitleChange = viewModel::onTitleChange,
        onContentChange = viewModel::onContentChange,
        onCompleteClick = {
            viewModel.createPost(
                onFailure = { message ->
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                },
            )
        },
        onBottomSheetDismiss = viewModel::onBottomSheetDismiss,
        modifier = modifier,
    )
}

@Composable
private fun PostScreen(
    uiState: PostUiState,
    onSearchQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onWriteClick: () -> Unit,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    onCompleteClick: () -> Unit,
    onBottomSheetDismiss: () -> Unit,
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
                    date = post.createdAt,
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

    if (uiState.isBottomSheetVisible) {
        PostBottomSheet(
            title = uiState.title,
            onTitleChange = onTitleChange,
            content = uiState.content,
            onContentChange = onContentChange,
            onCompleteClick = onCompleteClick,
            onDismissRequest = onBottomSheetDismiss,
        )
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PlaySoptTheme{
        PostScreen(
            uiState = PostUiState(
                posts = persistentListOf(
                    PostModel(
                        id = 1,
                        author = "민나",
                        createdAt = "2026.10.19",
                        title = "웹토리들아",
                        content = "세미나 열심히 듣고 있나요? 파이띵!ㅋㅋ",
                    ),
                    PostModel(
                        id = 2,
                        author = "상엽",
                        createdAt = "2026.10.06",
                        title = "모아요들아",
                        content = "사과 잊지 말고 항상 가지고 다녀라",
                    ),
                ),
            ),
            onSearchQueryChange = {},
            onSearchClick = {},
            onWriteClick = {},
            onTitleChange = {},
            onContentChange = {},
            onCompleteClick = {},
            onBottomSheetDismiss = {},
        )
    }
}
