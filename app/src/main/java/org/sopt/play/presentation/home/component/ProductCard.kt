package org.sopt.play.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil3.annotation.ExperimentalCoilApi
import coil3.asImage
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler
import org.sopt.play.R
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.core.util.noRippleClickable

@Composable
fun ProductCard(
    imageUrl: String,
    storeName: String,
    productName: String,
    discountRate: Int,
    price: String,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(160f / 200f),
            contentAlignment = Alignment.BottomEnd,
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = productName,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop,
            )

            Icon( imageVector = ImageVector.vectorResource(if (isFavorite) R.drawable.ic_favorite_fill else R.drawable.ic_favorite ),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable(onClick = onFavoriteClick)
                    .padding(all = 8.dp)
                    .size(24.dp),
                tint = if (isFavorite) PlaySoptTheme.colors.red else PlaySoptTheme.colors.white,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(top = 12.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = storeName,
                color = PlaySoptTheme.colors.black,
                style = PlaySoptTheme.typography.m14,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = productName,
                color = PlaySoptTheme.colors.black,
                style = PlaySoptTheme.typography.r14,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "$discountRate%",
                    color = PlaySoptTheme.colors.red,
                    style = PlaySoptTheme.typography.m14,
                )

                Text(
                    text = price,
                    color = PlaySoptTheme.colors.black,
                    style = PlaySoptTheme.typography.m14,
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    val context = LocalContext.current
    val previewHandler = AsyncImagePreviewHandler {
        ContextCompat.getDrawable(context, R.drawable.img_product_dummy)!!.asImage()
    }

    PlaySoptTheme {
        CompositionLocalProvider(LocalAsyncImagePreviewHandler provides previewHandler) {
            Row (
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                ProductCard(
                    imageUrl = "",
                    storeName = "스토어명",
                    productName = "상품명",
                    discountRate = 49,
                    price = "29,370",
                    isFavorite = false,
                    onFavoriteClick = {},
                    modifier = Modifier.weight(1f),
                )

                ProductCard(
                    imageUrl = "",
                    storeName = "스토어명이 아주 길어서 한 줄을 넘어가는 경우",
                    productName = "상품명이 아주 길어서 한 줄을 넘어가는 경우",
                    discountRate = 49,
                    price = "29,370",
                    isFavorite = false,
                    onFavoriteClick = {},
                    modifier = Modifier.weight(1f),
                )

                ProductCard(
                    imageUrl = "",
                    storeName = "스토어명",
                    productName = "상품명",
                    discountRate = 49,
                    price = "29,370",
                    isFavorite = true,
                    onFavoriteClick = {},
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
