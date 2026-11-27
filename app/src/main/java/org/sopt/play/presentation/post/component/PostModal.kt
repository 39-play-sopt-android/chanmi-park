package org.sopt.play.presentation.post.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.button.PlayButtonType
import org.sopt.play.core.component.modal.PlayModal
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PostModal(
    onDeleteClick: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PlayModal(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
    ) {
        Text(
            text = "게시글을 삭제할까요?",
            modifier = Modifier.fillMaxWidth(),
            color = PlaySoptTheme.colors.gray6,
            style = PlaySoptTheme.typography.m18,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PlayButton(
                text = "취소",
                onClick = onDismissRequest,
                modifier = Modifier.weight(1f),
                type = PlayButtonType.SECONDARY,
            )

            PlayButton(
                text = "삭제",
                onClick = onDeleteClick,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Preview
@Composable
private fun PostModalPreview() {
    PlaySoptTheme {
        PostModal(
            onDeleteClick = {},
            onDismissRequest = {},
        )
    }
}
