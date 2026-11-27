package org.sopt.play.presentation.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.play.core.navigation.MainTabRoute
import org.sopt.play.presentation.mypage.MypageRoute

fun NavController.navigateToMypage(
    navOptions: NavOptions? = null,
) = navigate(Mypage, navOptions)

fun NavGraphBuilder.mypageGraph(
    innerPadding: PaddingValues,
) {
    composable<Mypage> {
        MypageRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Mypage : MainTabRoute
