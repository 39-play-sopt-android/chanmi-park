package org.sopt.play.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import org.sopt.play.presentation.heart.navigation.heartGraph
import org.sopt.play.presentation.home.navigation.homeGraph
import org.sopt.play.presentation.login.navigation.loginGraph
import org.sopt.play.presentation.mypage.navigation.mypageGraph
import org.sopt.play.presentation.register.navigation.registerGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    val navController = appState.navController

    var registeredEmail by rememberSaveable { mutableStateOf("") }
    var registeredPassword by rememberSaveable { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = appState.startDestination,
    ) {
        loginGraph(
            innerPadding = innerPadding,
            navController = navController,
            isRegisteredUser = { email, password ->
                email == registeredEmail && password == registeredPassword
            },
        )

        registerGraph(
            innerPadding = innerPadding,
            navController = navController,
            onRegister = { email, password ->
                registeredEmail = email
                registeredPassword = password
            },
        )

        homeGraph(
            innerPadding = innerPadding,
        )

        heartGraph(
            innerPadding = innerPadding,
        )

        mypageGraph(
            innerPadding = innerPadding,
        )
    }
}
