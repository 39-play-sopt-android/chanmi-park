package org.sopt.play.core.component.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    textColor: Color,
    textStyle: TextStyle,
    placeholder: String,
    placeholderColor: Color,
    placeholderStyle: TextStyle,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource? = null,
    cursorColor: Color = textColor,
    suffix: (@Composable () -> Unit)? = null,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = isEnabled,
        textStyle = textStyle.copy(color = textColor),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(cursorColor),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeholderColor,
                            style = placeholderStyle,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    }
                    innerTextField()
                }

                suffix?.invoke()
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayBasicTextFieldPreview() {
    PlaySoptTheme {
        PlayBasicTextField(
            value = "",
            onValueChange = {},
            textColor = PlaySoptTheme.colors.gray5,
            textStyle = PlaySoptTheme.typography.m18,
            placeholder = "abc@email.com",
            placeholderColor = PlaySoptTheme.colors.gray2,
            placeholderStyle = PlaySoptTheme.typography.m18,
        )
    }
}
