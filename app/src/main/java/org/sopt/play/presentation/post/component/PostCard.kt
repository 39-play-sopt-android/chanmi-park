package org.sopt.play.presentation.post.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PostCard(
    author: String,
    date: String,
    title: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PlaySoptTheme.colors.gray1, shape = RoundedCornerShape(20.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = author,
                color = PlaySoptTheme.colors.gray3,
                style = PlaySoptTheme.typography.m12,
            )

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(12.dp)
                    .background(color = PlaySoptTheme.colors.gray3),
            )

            Text(
                text = date,
                color = PlaySoptTheme.colors.gray3,
                style = PlaySoptTheme.typography.m12,
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                color = PlaySoptTheme.colors.gray5,
                style = PlaySoptTheme.typography.m16,
            )

            Text(
                text = content,
                color = PlaySoptTheme.colors.gray5,
                style = PlaySoptTheme.typography.m14,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PostCardPreview() {
    PlaySoptTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PostCard(
                author = "응아니야",
                date = "2026.10.24",
                title = "글쓰기 테스트입니다 하하하하",
                content = "본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다. 본문입니다.",
            )

            PostCard(
                author = "민나",
                date = "2026.10.19",
                title = "웹토리들아",
                content = "세미나 열심히 듣고 있나요? 파이띵!ㅋㅋ",
            )
        }
    }
}
