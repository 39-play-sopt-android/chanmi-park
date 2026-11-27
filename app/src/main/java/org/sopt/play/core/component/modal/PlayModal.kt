package org.sopt.play.core.component.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayModal(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp)
                .background(
                    color = PlaySoptTheme.colors.white,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(all = 20.dp),
            content = content,
        )
    }
}

@Preview
@Composable
private fun PlayModalPreview() {
    PlaySoptTheme {
        PlayModal(onDismissRequest = {}) {
            Text(
                text = "모달 내용",
                color = PlaySoptTheme.colors.gray6,
                style = PlaySoptTheme.typography.m18,
            )
        }
    }
}
