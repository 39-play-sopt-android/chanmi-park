package org.sopt.play.presentation.login.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.play.core.navigation.Route
import org.sopt.play.core.util.clearBackStackNavOptions
import org.sopt.play.presentation.home.navigation.navigateToHome
import org.sopt.play.presentation.login.LoginRoute
import org.sopt.play.presentation.register.navigation.navigateToRegister

fun NavController.navigateToLogin(
    navOptions: NavOptions? = null,
) = navigate(Login, navOptions)

fun NavGraphBuilder.loginGraph(
    innerPadding: PaddingValues,
    navController: NavController,
    isRegisteredUser: (String, String) -> Boolean,
) {
    composable<Login> {
        LoginRoute(
            isRegisteredUser = isRegisteredUser,
            navigateToMain = {
                navController.navigateToHome(
                    navOptions = navController.clearBackStackNavOptions()
                )
            },
            navigateToRegister = { navController.navigateToRegister() },
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Login : Route
