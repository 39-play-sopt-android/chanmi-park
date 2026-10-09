package org.sopt.play.core.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayTextField(
    state: TextFieldState,
    placeholder: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    val internalInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isFocused by internalInteractionSource.collectIsFocusedAsState()
    val borderColor = when {
        isError -> PlaySoptTheme.colors.red
        isFocused -> PlaySoptTheme.colors.gray5
        else -> PlaySoptTheme.colors.gray2
    }

    BasicTextField(
        state = state,
        modifier = modifier,
        enabled = isEnabled,
        textStyle = PlaySoptTheme.typography.m18.copy(color = PlaySoptTheme.colors.gray5),
        keyboardOptions = keyboardOptions,
        onKeyboardAction = onKeyboardAction,
        lineLimits = TextFieldLineLimits.SingleLine,
        inputTransformation = inputTransformation,
        outputTransformation = outputTransformation,
        interactionSource = internalInteractionSource,
        cursorBrush = SolidColor(PlaySoptTheme.colors.gray5),
        decorator = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PlaySoptTheme.colors.white, RoundedCornerShape(12.dp))
                    .border(2.dp, borderColor, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (state.text.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = PlaySoptTheme.colors.gray2,
                        style = PlaySoptTheme.typography.m18,
                    )
                }
                innerTextField()
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayTextFieldPreview() {
    val state = rememberTextFieldState(initialText = "")

    PlaySoptTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp))
        {
            PlayTextField(state = state, placeholder = "abc@email.com")
            PlayTextField(state = rememberTextFieldState("abc@email.com"), placeholder = "abc@email.com")
            PlayTextField(state = rememberTextFieldState("abc.com"), placeholder = "abc@email.com", isError = true)
        }
    }
}