package org.sopt.play.core.component.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun PlayTabMenu(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .noRippleClickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(
                    color = if (isSelected) PlaySoptTheme.colors.black else Color.Transparent,
                    shape = CircleShape,
                ),
        )

        Text(
            text = text,
            color = if (isSelected) PlaySoptTheme.colors.black else PlaySoptTheme.colors.gray3,
            style = PlaySoptTheme.typography.m18,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayTabMenuPreview() {
    PlaySoptTheme {
        Row {
            PlayTabMenu(
                text = "메뉴",
                isSelected = true,
                onClick = {},
            )

            PlayTabMenu(
                text = "메뉴",
                isSelected = false,
                onClick = {},
            )
        }
    }
}
