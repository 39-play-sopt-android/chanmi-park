package org.sopt.play.core.util

import androidx.navigation.NavController
import androidx.navigation.navOptions

fun NavController.clearBackStackNavOptions() = navOptions {
    popUpTo(0) {
        inclusive = true
    }
    launchSingleTop = true
}
