package org.sopt.play.presentation.heart.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.play.core.navigation.MainTabRoute
import org.sopt.play.presentation.heart.HeartScreen

fun NavController.navigateToHeart(
    navOptions: NavOptions? = null,
) = navigate(Heart, navOptions)

fun NavGraphBuilder.heartGraph(
    innerPadding: PaddingValues,
) {
    composable<Heart> {
        HeartScreen(
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Heart : MainTabRoute
