package org.sopt.play.presentation.main

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.play.presentation.main.component.MainBottomBar
import org.sopt.play.core.navigation.MainTab

@Composable
fun MainScreen(
    appState: MainAppState = rememberMainAppState(),
) {
    val currentTab = appState.currentTab

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        bottomBar = {
            MainBottomBar(
                isVisible = currentTab != null,
                tabs = MainTab.entries,
                currentTab = currentTab,
                onTabSelected = appState::navigate,
            )
        },
    ) { innerPadding ->
        MainNavHost(
            appState = appState,
            innerPadding = innerPadding,
        )
    }
}
