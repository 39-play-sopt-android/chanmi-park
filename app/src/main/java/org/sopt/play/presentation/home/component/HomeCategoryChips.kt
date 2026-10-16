package org.sopt.play.presentation.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.core.component.chip.PlayChip
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun HomeCategoryChips(
    categories: List<String>,
    selectedIndex: Int,
    onCategoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        categories.forEachIndexed { index, category ->
            PlayChip(
                text = category,
                isSelected = index == selectedIndex,
                onClick = { onCategoryClick(index) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeCategoryChipsPreview() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    PlaySoptTheme {
        HomeCategoryChips(
            categories = listOf("전체", "상의", "팬츠", "원피스", "아우터", "스커트", "슈즈", "가방", "이너웨어/잠옷", "폰꾸미기"),
            selectedIndex = selectedIndex,
            onCategoryClick = { selectedIndex = it },
        )
    }
}
