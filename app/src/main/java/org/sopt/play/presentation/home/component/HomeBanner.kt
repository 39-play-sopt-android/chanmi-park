package org.sopt.play.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.theme.PlaySoptTheme

@Composable
fun HomeBanner(
    banners: List<Int>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(banners) { banner ->
            Image(
                painter = painterResource(banner),
                contentDescription = null,
                modifier = Modifier.size(width = 328.dp, height = 195.dp),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBannerPreview() {
    PlaySoptTheme {
        HomeBanner(
            banners = listOf(
                R.drawable.img_banner_1,
                R.drawable.img_banner_2,
                R.drawable.img_banner_3,
            ),
        )
    }
}
