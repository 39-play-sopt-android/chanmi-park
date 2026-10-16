package org.sopt.play.presentation.register.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.play.core.navigation.Route
import org.sopt.play.presentation.register.RegisterRoute

fun NavController.navigateToRegister(
    navOptions: NavOptions? = null,
) = navigate(Register, navOptions)

fun NavGraphBuilder.registerGraph(
    innerPadding: PaddingValues,
    navController: NavController,
    onRegister: (String, String) -> Unit,
) {
    composable<Register> {
        RegisterRoute(
            onRegister = onRegister,
            navigateUp = { navController.popBackStack() },
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Serializable
data object Register : Route
