package org.sopt.play.core.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun PlayChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Text(
        text = text,
        modifier = modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .background(color = if (isSelected) PlaySoptTheme.colors.gray5 else PlaySoptTheme.colors.white)
            .border(
                width = 1.dp,
                color = if (isSelected) PlaySoptTheme.colors.gray5 else PlaySoptTheme.colors.gray2,
                shape = RoundedCornerShape(6.dp),
            )
            .noRippleClickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        color = if (isSelected) PlaySoptTheme.colors.white else PlaySoptTheme.colors.gray5,
        style = PlaySoptTheme.typography.m14,
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayChipPreview() {
    PlaySoptTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PlayChip(
                text = "칩",
                isSelected = false,
                onClick = {},
            )

            PlayChip(
                text = "칩",
                isSelected = true,
                onClick = {},
            )
        }
    }
}
