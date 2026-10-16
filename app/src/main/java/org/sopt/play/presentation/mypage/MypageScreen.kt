package org.sopt.play.presentation.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun MypageScreen(
    modifier: Modifier = Modifier
){
    Text(
        text = "마이페이지",
        modifier = modifier
            .fillMaxSize()
            .background(color = PlaySoptTheme.colors.white)
            .wrapContentSize(Alignment.Center),
        color = PlaySoptTheme.colors.black,
        style = PlaySoptTheme.typography.m18,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun MypageScreenPreview() {
    PlaySoptTheme{
        MypageScreen()
    }
}
