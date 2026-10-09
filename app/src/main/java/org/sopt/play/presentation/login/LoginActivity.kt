package org.sopt.play.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.MainActivity
import org.sopt.play.presentation.signup.SignUpActivity
import kotlin.jvm.java

class LoginActivity : ComponentActivity() {

    private var registeredEmail by mutableStateOf("")
    private var registeredPassword by mutableStateOf("")

    private val signUpLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            registeredEmail =
                result.data?.getStringExtra("email") ?: ""

            registeredPassword =
                result.data?.getStringExtra("password") ?: ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets.safeDrawing,
                ) { innerPadding ->

                    LoginScreen(
                        onLoginClick = {email, password ->
                            if (email == registeredEmail && password == registeredPassword){
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                            else Toast.makeText(this, "이메일 또는 비밀번호가 올바르지 않아요.", Toast.LENGTH_SHORT).show()
                        },
                        onSignupClick = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            signUpLauncher.launch(intent)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onSignupClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val emailState = rememberTextFieldState(initialText = "")
    val passwordState = rememberTextFieldState(initialText = "")

    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailState.text).matches()
    val isPasswordValid = passwordState.text.length >= 6

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
            text = "이메일로 로그인하기",
            color = PlaySoptTheme.colors.black,
            style = PlaySoptTheme.typography.b28,
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayLabelTextField(
            labelText = "이메일 주소",
            placeholder ="abc@email.com",
            state = emailState,
            errorMessage = if(emailState.text.isNotEmpty() && !isEmailValid) "올바른 이메일을 입력해주세요." else null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            onKeyboardAction = { focusManager.moveFocus(FocusDirection.Next) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호",
            placeholder ="6자 이상의 비밀번호",
            state = passwordState,
            errorMessage = if(passwordState.text.isNotEmpty() && !isPasswordValid) "비밀번호는 6자 이상 입력해주세요." else null,
            outputTransformation = OutputTransformation { replace(0, length, "•".repeat(length)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            onKeyboardAction = {
                focusManager.clearFocus()
                keyboardController?.hide()
            },
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayButton(
            text = "로그인",
            onClick = { onLoginClick(emailState.text.toString(), passwordState.text.toString()) },
            isEnabled = isEmailValid && isPasswordValid,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "아직 계정이 없으신가요?",
                color = PlaySoptTheme.colors.gray3,
                style = PlaySoptTheme.typography.m14,
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "회원가입하기",
                modifier = Modifier.clickable( onClick = onSignupClick ),
                color = PlaySoptTheme.colors.gray6,
                style = PlaySoptTheme.typography.m14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PlaySoptTheme {
        LoginScreen(
            onLoginClick = { _ , _ -> } ,
            onSignupClick = {},
        )
    }
}
