package org.sopt.play.core.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PlayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource? = null,
    suffix: (@Composable () -> Unit)? = null,
) {
    val internalInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val isFocused by internalInteractionSource.collectIsFocusedAsState()
    val borderColor = when {
        isError -> PlaySoptTheme.colors.red
        isFocused -> PlaySoptTheme.colors.gray5
        else -> PlaySoptTheme.colors.gray2
    }

    PlayBasicTextField(
        value = value,
        onValueChange = onValueChange,
        textColor = PlaySoptTheme.colors.gray5,
        textStyle = PlaySoptTheme.typography.m18,
        placeholder = placeholder,
        placeholderColor = PlaySoptTheme.colors.gray2,
        placeholderStyle = PlaySoptTheme.typography.m18,
        modifier = modifier
            .fillMaxWidth()
            .background(PlaySoptTheme.colors.white, RoundedCornerShape(12.dp))
            .border(2.dp, borderColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        isEnabled = isEnabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        interactionSource = internalInteractionSource,
        suffix = suffix,
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayTextFieldPreview() {
    PlaySoptTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp))
        {
            PlayTextField(value = "", onValueChange = {}, placeholder = "abc@email.com")
            PlayTextField(value = "abc@email.com", onValueChange = {}, placeholder = "abc@email.com")
            PlayTextField(value = "abc.com", onValueChange = {}, placeholder = "abc@email.com", isError = true)
        }
    }
}
