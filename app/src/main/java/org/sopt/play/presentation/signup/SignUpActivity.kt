package org.sopt.play.presentation.signup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.login.LoginActivity
import kotlin.jvm.java

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeDrawing,
                ) { innerPadding ->
                    val context = LocalContext.current

                    SignUpScreen(
                        onSignUpClick = { email, password ->
                            val resultIntent = Intent(context, LoginActivity::class.java).apply{
                                putExtra("email",email)
                                putExtra("password",password)
                            }
                            setResult(RESULT_OK, resultIntent)
                            finish()
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun SignUpScreen(
    onSignUpClick: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val nameState = rememberTextFieldState(initialText = "")
    val emailState = rememberTextFieldState(initialText = "")
    val passwordState = rememberTextFieldState(initialText = "")
    val passwordCheckState = rememberTextFieldState(initialText = "")

    val isNameValid = nameState.text.isNotBlank()
    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailState.text).matches()
    val isPasswordValid = passwordState.text.length >= 6
    val isPasswordCheckValid = passwordState.text == passwordCheckState.text

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
            state = nameState,
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "이메일 주소",
            placeholder ="abc@email.com",
            state = emailState,
            errorMessage = if(emailState.text.isNotEmpty() && !isEmailValid) "올바른 이메일을 입력해주세요." else null,
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호",
            placeholder ="6자 이상의 비밀번호",
            state = passwordState,
            errorMessage = if(passwordState.text.isNotEmpty() && !isPasswordValid) "비밀번호는 6자 이상 입력해주세요." else null,
            outputTransformation = OutputTransformation { replace(0, length, "•".repeat(length)) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호 확인",
            placeholder ="6자 이상의 비밀번호",
            state = passwordCheckState,
            errorMessage = if(passwordCheckState.text.isNotEmpty() && !isPasswordCheckValid) "비밀번호와 동일하게 입력해주세요." else null,
            outputTransformation = OutputTransformation { replace(0, length, "•".repeat(length)) },
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayButton(
            text = "회원가입",
            onClick = { onSignUpClick(emailState.text.toString(), passwordState.text.toString()) },
            isEnabled = isNameValid && isEmailValid && isPasswordValid && isPasswordCheckValid,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    PlaySoptTheme {
        SignUpScreen(
            onSignUpClick = { _, _ -> }
        )
    }
}
