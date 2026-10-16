package org.sopt.play.core.navigation

import org.sopt.play.presentation.heart.navigation.Heart
import org.sopt.play.presentation.mypage.navigation.Mypage

enum class MainTab(
    val title: String,
    val route: MainTabRoute,
) {
    HEART(
        title = "찜",
        route = Heart,
    ),
    MYPAGE(
        title = "마이페이지",
        route = Mypage,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }
    }
}