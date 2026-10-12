package org.sopt.play.core.theme

import androidx.activity.compose.LocalActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LocalPlaySoptColors = staticCompositionLocalOf { defaultPlaySoptColors }
private val LocalPlaySoptTypography = staticCompositionLocalOf { defaultPlaySoptTypography }

private val PlayMaterialColorScheme = lightColorScheme(
    background = White,
)

object PlaySoptTheme {
    val colors: PlaySoptColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPlaySoptColors.current

    val typography: PlaySoptTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalPlaySoptTypography.current
}

@Composable
private fun ProvidePlaySoptColorsAndTypography(
    colors: PlaySoptColors,
    typography: PlaySoptTypography,
    content: @Composable () -> Unit
){
    CompositionLocalProvider(
        LocalPlaySoptColors provides colors,
        LocalPlaySoptTypography provides typography,
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
        val activity = LocalActivity.current

        SideEffect {
            activity?.window?.let {
                WindowCompat.getInsetsController(it, view).isAppearanceLightStatusBars = true
            }
        }

        MaterialTheme(
            colorScheme = PlayMaterialColorScheme,
            content = content
        )
    }
}
