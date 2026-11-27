package org.sopt.play.presentation.post.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.component.textfield.PlayIconTextField
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun PostSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PlayIconTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = "검색어를 입력하세요",
        iconRes = R.drawable.ic_search,
        onIconClick = onSearchClick,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun PostSearchTextFieldPreview() {
    PlaySoptTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            PostSearchTextField(
                value = "",
                onValueChange = {},
                onSearchClick = {},
            )

            PostSearchTextField(
                value = "솝트",
                onValueChange = {},
                onSearchClick = {},
            )
        }
    }
}
