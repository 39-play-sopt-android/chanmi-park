package org.sopt.play.core.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = CircleShape)
            .background(color = if (isEnabled) PlaySoptTheme.colors.black else PlaySoptTheme.colors.gray1)
            .clickable(enabled = isEnabled, onClick = onClick)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            color = if (isEnabled) PlaySoptTheme.colors.gray1 else PlaySoptTheme.colors.gray3,
            style = PlaySoptTheme.typography.sb14,
        )
    }
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
    }
}