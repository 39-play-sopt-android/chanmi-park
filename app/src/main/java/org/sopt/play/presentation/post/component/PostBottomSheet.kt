package org.sopt.play.presentation.post.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.bottomsheet.PlayBottomSheet
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.theme.PlaySoptTheme

private const val TITLE_MAX_LENGTH = 20
private const val CONTENT_MAX_LENGTH = 1000

@Composable
fun PostBottomSheet(
    title: String,
    onTitleChange: (String) -> Unit,
    content: String,
    onContentChange: (String) -> Unit,
    onCompleteClick: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PlayBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
    ) {
        PlayLabelTextField(
            labelText = "제목",
            placeholder = "제목을 입력하세요.",
            value = title,
            onValueChange = { if (it.length <= TITLE_MAX_LENGTH) onTitleChange(it) },
        )

        Spacer(modifier = Modifier.height(12.dp))

        PlayLabelTextField(
            labelText = "본문",
            placeholder = "본문을 입력하세요.",
            value = content,
            onValueChange = { if (it.length <= CONTENT_MAX_LENGTH) onContentChange(it) },
        )

        Spacer(modifier = Modifier.height(20.dp))

        PlayButton(
            text = "완료",
            onClick = onCompleteClick,
            isEnabled = title.isNotBlank() && content.isNotBlank(),
        )
    }
}

@Preview
@Composable
private fun PostBottomSheetPreview() {
    PlaySoptTheme {
        PostBottomSheet(
            title = "",
            onTitleChange = {},
            content = "",
            onContentChange = {},
            onCompleteClick = {},
            onDismissRequest = {},
        )
    }
}
