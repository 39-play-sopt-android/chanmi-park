package org.sopt.play.core.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun PlayButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    type: PlayButtonType = PlayButtonType.PRIMARY,
) {
    val backgroundColor = when {
        !isEnabled -> PlaySoptTheme.colors.gray1
        type == PlayButtonType.PRIMARY -> PlaySoptTheme.colors.black
        else -> PlaySoptTheme.colors.gray1
    }
    val textColor = when {
        !isEnabled -> PlaySoptTheme.colors.gray3
        type == PlayButtonType.PRIMARY -> PlaySoptTheme.colors.gray1
        else -> PlaySoptTheme.colors.gray5
    }

    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = CircleShape)
            .background(color = backgroundColor)
            .noRippleClickable(enabled = isEnabled, onClick = onClick)
            .padding(all = 16.dp),
        color = textColor,
        style = PlaySoptTheme.typography.sb14,
        textAlign = TextAlign.Center
    )
}

enum class PlayButtonType {
    PRIMARY,
    SECONDARY,
}

@Preview(showBackground = true)
@Composable
private fun PlayButtonPreview() {
    Column {
        PlayButton(
            text = "로그인",
            onClick = {},
            isEnabled = true
        )

        PlayButton(
            text = "로그인",
            onClick = {},
            isEnabled = false
        )

        PlayButton(
            text = "취소",
            onClick = {},
            type = PlayButtonType.SECONDARY
        )
    }
}
