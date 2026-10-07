package org.sopt.play.presentation.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.Greeting

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    val nameState = rememberTextFieldState(initialText = "")
    val emailState = rememberTextFieldState(initialText = "")
    val passwordState = rememberTextFieldState(initialText = "")
    val passwordCheckState = rememberTextFieldState(initialText = "")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 60.dp)
            .background(color = PlaySoptTheme.colors.white)
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
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호",
            placeholder ="6자 이상의 비밀번호",
            state = passwordState,
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호 확인",
            placeholder ="6자 이상의 비밀번호",
            state = passwordCheckState,
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayButton(
            text = "회원가입",
            onClick = {  },
            isEnabled = if(emailState.text.isNotBlank() && passwordState.text.isNotBlank()) true else false,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaySoptTheme {
        SignUpScreen()
    }
}