package org.sopt.play.core.component.textfield

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayLabelTextField(
    labelText: String,
    placeholder: String,
    state: TextFieldState,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onKeyboardAction: KeyboardActionHandler? = null,
    inputTransformation: InputTransformation? = null,
    outputTransformation: OutputTransformation? = null,
    interactionSource: MutableInteractionSource? = null,
){
    Column(
        modifier = modifier.animateContentSize(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = labelText,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = PlaySoptTheme.colors.gray6,
            style = PlaySoptTheme.typography.sb16,
        )

        PlayTextField(
            state = state,
            placeholder = placeholder,
            isError = !errorMessage.isNullOrBlank(),
            keyboardOptions = keyboardOptions,
            onKeyboardAction = onKeyboardAction,
            inputTransformation = inputTransformation,
            outputTransformation = outputTransformation,
            interactionSource = interactionSource,
        )

        AnimatedVisibility(
            visible = !errorMessage.isNullOrBlank(),
            enter = slideInVertically(initialOffsetY = { -it }),
            exit = slideOutVertically(targetOffsetY = { -it }),
        ) {
            Text(
                text = errorMessage.orEmpty(),
                modifier = Modifier.padding(horizontal = 8.dp),
                color = PlaySoptTheme.colors.red,
                style = PlaySoptTheme.typography.m14,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun PlayLabelTextFieldPreview(){
    val state = rememberTextFieldState(initialText = "")

    PlaySoptTheme{
        PlayLabelTextField(
            labelText = "이메일 주소",
            placeholder = "abc@email.com",
            state = state,
        )
    }
}