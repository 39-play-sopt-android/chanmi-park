package org.sopt.play.presentation.post.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun PostFloatingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_plus_28),
        contentDescription = null,
        modifier = modifier
            .dropShadow(
                shape = CircleShape,
                shadow = Shadow(
                    radius = 12.dp,
                    color = Color.Black.copy(alpha = 0.15f),
                    offset = DpOffset(x = 0.dp, y = 4.dp),
                ),
            )
            .background(color = PlaySoptTheme.colors.red, shape = CircleShape)
            .noRippleClickable(onClick = onClick)
            .padding(16.dp)
            .size(28.dp),
        tint = PlaySoptTheme.colors.white,
    )
}

@Preview(showBackground = true)
@Composable
private fun PostFloatingButtonPreview() {
    PlaySoptTheme {
        PostFloatingButton(
            onClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}
