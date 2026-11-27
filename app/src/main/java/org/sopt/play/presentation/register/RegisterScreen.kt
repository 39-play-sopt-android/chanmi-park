package org.sopt.play.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun RegisterRoute(
    onRegister: (String, String) -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RegisterScreen(
        uiState = uiState,
        onNameChange = viewModel::onNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onPasswordCheckChange = viewModel::onPasswordCheckChange,
        onRegisterClick = {
            viewModel.register(onRegister)
            navigateUp()
        },
        modifier = modifier,
    )
}

@Composable
private fun RegisterScreen(
    uiState: RegisterUiState,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordCheckChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PlaySoptTheme.colors.white)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp, bottom = 16.dp)
    ) {
        Text(
            text = "이메일로 회원가입",
            color = PlaySoptTheme.colors.black,
            style = PlaySoptTheme.typography.b28,
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayLabelTextField(
            labelText = "이름",
            placeholder ="홍길동",
            value = uiState.name,
            onValueChange = onNameChange,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "이메일 주소",
            placeholder ="abc@email.com",
            value = uiState.email,
            onValueChange = onEmailChange,
            errorMessage = if(uiState.email.isNotEmpty() && !uiState.isEmailValid) "올바른 이메일을 입력해주세요." else null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호",
            placeholder ="6자 이상의 비밀번호",
            value = uiState.password,
            onValueChange = onPasswordChange,
            errorMessage = if(uiState.password.isNotEmpty() && !uiState.isPasswordValid) "비밀번호는 6자 이상 입력해주세요." else null,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Next) }),
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호 확인",
            placeholder ="6자 이상의 비밀번호",
            value = uiState.passwordCheck,
            onValueChange = onPasswordCheckChange,
            errorMessage = if(uiState.passwordCheck.isNotEmpty() && !uiState.isPasswordCheckValid) "비밀번호와 동일하게 입력해주세요." else null,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    keyboardController?.hide()
                },
            ),
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayButton(
            text = "회원가입",
            onClick = onRegisterClick,
            isEnabled = uiState.isRegisterEnabled,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreivew() {
    PlaySoptTheme {
        RegisterScreen(
            uiState = RegisterUiState(),
            onNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onPasswordCheckChange = {},
            onRegisterClick = {},
        )
    }
}