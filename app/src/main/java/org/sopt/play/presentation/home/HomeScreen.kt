package org.sopt.play.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.component.topbar.PlayTopBar
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.home.component.HomeBanner
import org.sopt.play.presentation.home.component.HomeCategoryChips
import org.sopt.play.presentation.home.component.HomeMenuTab
import org.sopt.play.presentation.home.component.ProductCard
import org.sopt.play.presentation.home.model.dummyProducts

private val menus = listOf("2배적립", "홈", "셀렉티드", "브랜드", "뷰티", "라이프", "랭킹")

private val categories = listOf("전체", "상의", "팬츠", "원피스", "아우터", "스커트", "슈즈", "가방", "이너웨어/잠옷", "폰꾸미기")

private val banners = listOf(
    R.drawable.img_banner_1,
    R.drawable.img_banner_2,
    R.drawable.img_banner_3,
)

@Composable
fun HomeScreen(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
){
    var selectedMenuIndex by remember { mutableIntStateOf(1) }
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    var products by remember { mutableStateOf(dummyProducts) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = PlaySoptTheme.colors.white),
    ) {
        item {
            PlayTopBar( onSearchClick = onSearchClick )
        }

        item {
            HomeMenuTab(
                menus = menus,
                selectedIndex = selectedMenuIndex,
                onMenuClick = { selectedMenuIndex = it },
            )
        }

        item {
            HomeBanner(banners = banners)
        }

        item {
            Text(
                text = "김솝트님을 위한 추천 아이템",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 20.dp, bottom = 12.dp),
                color = PlaySoptTheme.colors.black,
                style = PlaySoptTheme.typography.m18,
            )
        }

        item {
            HomeCategoryChips(
                categories = categories,
                selectedIndex = selectedCategoryIndex,
                onCategoryClick = { selectedCategoryIndex = it },
            )
        }

        item {
            Spacer(modifier = Modifier.height(18.dp))
        }

        item {
            Column {
                products.chunked(2).forEach { rowProducts ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        rowProducts.forEach { product ->
                            ProductCard(
                                imageUrl = product.imageUrl,
                                storeName = product.storeName,
                                productName = product.productName,
                                discountRate = product.discountRate,
                                price = product.price,
                                isFavorite = product.isFavorite,
                                onFavoriteClick = {
                                    products = products.map {
                                        if (it.id == product.id) it.copy(isFavorite = !it.isFavorite) else it
                                    }
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }

                        if (rowProducts.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    PlaySoptTheme{
        HomeScreen(
            onSearchClick = {}
        )
    }
}
