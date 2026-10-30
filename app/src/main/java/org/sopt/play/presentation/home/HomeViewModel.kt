package org.sopt.play.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.play.R
import org.sopt.play.presentation.home.model.dummyProducts

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        HomeUiState(
            menus = listOf("2배적립", "홈", "셀렉티드", "브랜드", "뷰티", "라이프", "랭킹"),
            selectedMenuIndex = 1,
            banners = listOf(
                R.drawable.img_banner_1,
                R.drawable.img_banner_2,
                R.drawable.img_banner_3,
            ),
            categories = listOf("전체", "상의", "팬츠", "원피스", "아우터", "스커트", "슈즈", "가방", "이너웨어/잠옷", "폰꾸미기"),
            selectedCategoryIndex = 0,
            products = dummyProducts,
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onMenuClick(index: Int) {
        _uiState.update { it.copy(selectedMenuIndex = index) }
    }

    fun onCategoryClick(index: Int) {
        _uiState.update { it.copy(selectedCategoryIndex = index) }
    }

    fun onFavoriteClick(productId: Int) {
        _uiState.update { state ->
            state.copy(
                products = state.products.map {
                    if (it.id == productId) it.copy(isFavorite = !it.isFavorite) else it
                }
            )
        }
    }
}
