package org.sopt.play.core.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayBasicButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = CircleShape)
            .background(color = if (enabled) PlaySoptTheme.colors.black else PlaySoptTheme.colors.gray1)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            color = if (enabled) PlaySoptTheme.colors.gray1 else PlaySoptTheme.colors.gray3,
            style = PlaySoptTheme.typography.sb14,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayBasicButtonPreview() {
    Column {
        PlayBasicButton(
            text = "로그인",
            onClick = {},
            enabled = true
        )

        PlayBasicButton(
            text = "로그인",
            onClick = {},
            enabled = false
        )
    }
}