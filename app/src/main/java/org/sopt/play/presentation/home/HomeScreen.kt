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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.sopt.play.R
import org.sopt.play.core.component.topbar.PlayTopBar
import org.sopt.play.core.theme.PlaySoptTheme
import org.sopt.play.presentation.home.component.HomeBanner
import org.sopt.play.presentation.home.component.HomeCategoryChips
import org.sopt.play.presentation.home.component.HomeMenuTab
import org.sopt.play.presentation.home.component.ProductCard
import org.sopt.play.presentation.home.model.dummyProducts

@Composable
fun HomeRoute(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState,
        onSearchClick = onSearchClick,
        onMenuClick = viewModel::onMenuClick,
        onCategoryClick = viewModel::onCategoryClick,
        onFavoriteClick = viewModel::onFavoriteClick,
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    uiState: HomeUiState,
    onSearchClick: () -> Unit,
    onMenuClick: (Int) -> Unit,
    onCategoryClick: (Int) -> Unit,
    onFavoriteClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = PlaySoptTheme.colors.white),
    ) {
        PlayTopBar( onSearchClick = onSearchClick )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                HomeMenuTab(
                    menus = uiState.menus,
                    selectedIndex = uiState.selectedMenuIndex,
                    onMenuClick = onMenuClick,
                )
            }

            item {
                HomeBanner(banners = uiState.banners)
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
                    categories = uiState.categories,
                    selectedIndex = uiState.selectedCategoryIndex,
                    onCategoryClick = onCategoryClick,
                )
            }

            item {
                Spacer(modifier = Modifier.height(18.dp))
            }

            item {
                Column {
                    uiState.products.chunked(2).forEach { rowProducts ->
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
                                    onFavoriteClick = { onFavoriteClick(product.id) },
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
}

@Preview
@Composable
private fun HomeScreenPreview() {
    PlaySoptTheme{
        HomeScreen(
            uiState = HomeUiState(
                menus = listOf("2배적립", "홈", "셀렉티드", "브랜드", "뷰티", "라이프", "랭킹"),
                selectedMenuIndex = 1,
                banners = listOf(R.drawable.img_banner_1, R.drawable.img_banner_2, R.drawable.img_banner_3),
                categories = listOf("전체", "상의", "팬츠", "원피스", "아우터"),
                products = dummyProducts,
            ),
            onSearchClick = {},
            onMenuClick = {},
            onCategoryClick = {},
            onFavoriteClick = {},
        )
    }
}
