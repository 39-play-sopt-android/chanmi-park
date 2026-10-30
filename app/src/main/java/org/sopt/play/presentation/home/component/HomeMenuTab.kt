package org.sopt.play.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.play.core.component.tab.PlayTabMenu
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun HomeMenuTab(
    menus: List<String>,
    selectedIndex: Int,
    onMenuClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PlaySoptTheme.colors.white)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        menus.forEachIndexed { index, menu ->
            PlayTabMenu(
                text = menu,
                isSelected = index == selectedIndex,
                onClick = { onMenuClick(index) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeMenuTabPreview() {
    var selectedIndex by remember { mutableIntStateOf(1) }

    PlaySoptTheme {
        HomeMenuTab(
            menus = listOf("2배적립", "홈", "셀렉티드", "브랜드", "뷰티", "라이프", "랭킹"),
            selectedIndex = selectedIndex,
            onMenuClick = { selectedIndex = it },
        )
    }
}
