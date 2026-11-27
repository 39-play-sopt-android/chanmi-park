package org.sopt.play.core.component.textfield

import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun PlayIconTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit = {},
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource? = null,
) {
    PlayTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        modifier = modifier,
        isEnabled = isEnabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        suffix = {
            Icon(
                imageVector = ImageVector.vectorResource(iconRes),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .noRippleClickable(onClick = onIconClick)
                    .size(24.dp),
                tint = PlaySoptTheme.colors.gray3,
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayIconTextFieldPreview() {
    PlaySoptTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PlayIconTextField(
                value = "",
                onValueChange = {},
                placeholder = "검색어를 입력하세요",
                iconRes = R.drawable.ic_search,
            )

            PlayIconTextField(
                value = "솝트",
                onValueChange = {},
                placeholder = "검색어를 입력하세요",
                iconRes = R.drawable.ic_search,
            )
        }
    }
}
