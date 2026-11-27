package org.sopt.play.presentation.home

import org.sopt.play.presentation.home.model.Product

data class HomeUiState(
    val menus: List<String> = emptyList(),
    val selectedMenuIndex: Int = 0,
    val banners: List<Int> = emptyList(),
    val categories: List<String> = emptyList(),
    val selectedCategoryIndex: Int = 0,
    val products: List<Product> = emptyList(),
)
