package org.sopt.play.core.navigation

import androidx.annotation.DrawableRes
import org.sopt.play.R
import org.sopt.play.presentation.heart.navigation.Heart
import org.sopt.play.presentation.home.navigation.Home
import org.sopt.play.presentation.mypage.navigation.Mypage

enum class MainTab(
    @DrawableRes val iconRes: Int,
    @DrawableRes val selectedIconRes: Int,
    val title: String,
    val route: MainTabRoute,
) {
    HOME(
        iconRes = R.drawable.ic_home,
        selectedIconRes = R.drawable.ic_home_fill,
        title = "홈",
        route = Home,
    ),
    HEART(
        iconRes = R.drawable.ic_favorite,
        selectedIconRes = R.drawable.ic_favorite_fill,
        title = "찜",
        route = Heart,
    ),
    MYPAGE(
        iconRes = R.drawable.ic_user,
        selectedIconRes = R.drawable.ic_user_fill,
        title = "마이페이지",
        route = Mypage,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }
    }
}
