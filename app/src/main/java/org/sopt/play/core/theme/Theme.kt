package org.sopt.play.core.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object PlaySoptTheme {
    val colors: PlaySoptColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPlaySoptColorsProvider.current

    val typography: PlaySoptTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalPlaySoptTypographyProvider.current
}

@Composable
private fun ProvidePlaySoptColorsAndTypography(
    colors: PlaySoptColors,
    typography: PlaySoptTypography,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalPlaySoptColorsProvider provides colors,
        LocalPlaySoptTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun PlaySoptTheme(
    content: @Composable () -> Unit
) {
    ProvidePlaySoptColorsAndTypography(
        colors = defaultPlaySoptColors,
        typography = defaultPlaySoptTypography,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }

        MaterialTheme(
            content = content
        )
    }
}