package org.sopt.play.presentation.login

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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.button.PlayButton
import org.sopt.play.core.component.textfield.PlayLabelTextField
import org.sopt.play.core.component.textfield.PlayTextField
import org.sopt.play.core.theme.PlaySoptTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaySoptTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    LoginScreen(
                        onLoginClick = {},
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val emailState = rememberTextFieldState(initialText = "")
    val passwordState = rememberTextFieldState(initialText = "")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 60.dp)
            .background(color = PlaySoptTheme.colors.white)
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
        )

        Spacer(modifier = Modifier.height(32.dp))

        PlayLabelTextField(
            labelText = "비밀번호",
            placeholder ="6자 이상의 비밀번호",
            state = passwordState,
        )

        Spacer(modifier = Modifier.height(40.dp))

        PlayButton(
            text = "로그인",
            onClick = onLoginClick,
            isEnabled = if(emailState.text.isNotBlank() && passwordState.text.isNotBlank()) true else false,
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
                color = PlaySoptTheme.colors.gray6,
                style = PlaySoptTheme.typography.m14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaySoptTheme {
        LoginScreen(
            onLoginClick = {}
        )
    }
}