package org.sopt.play.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.play.core.navigation.MainTab
import org.sopt.play.core.navigation.Route
import org.sopt.play.presentation.heart.navigation.navigateToHeart
import org.sopt.play.presentation.home.navigation.Home
import org.sopt.play.presentation.home.navigation.navigateToHome
import org.sopt.play.presentation.mypage.navigation.navigateToMypage

@Stable
class MainAppState(
    val navController: NavHostController,
) {
    val startDestination: Route = Home

    val currentTab: MainTab?
        @Composable get() {
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val destination = currentBackStackEntry?.destination
            return MainTab.find { route -> destination?.hasRoute(route::class) == true }
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                }
            }
            launchSingleTop = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions = navOptions)
            MainTab.HEART -> navController.navigateToHeart(navOptions = navOptions)
            MainTab.MYPAGE -> navController.navigateToMypage(navOptions = navOptions)
        }
    }
}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
): MainAppState = remember(navController) {
    MainAppState(navController)
}
