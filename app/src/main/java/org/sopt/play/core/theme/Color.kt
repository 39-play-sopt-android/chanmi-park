package org.sopt.play.core.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF121212)
val Gray1 = Color(0xFFF7F7F7)
val Gray2 = Color(0xFFD1D5D6)
val Gray3 = Color(0xFFB2BABD)
val Gray5 = Color(0xFF505559)
val Gray6 = Color(0xFF23272A)
val Red = Color(0xFFFF4D4D)
val White = Color(0xFFFFFFFF)

@Immutable
class PlaySoptColors(
    val black: Color,
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray5: Color,
    val gray6: Color,
    val red: Color,
    val white: Color,
)


val defaultPlaySoptColors = PlaySoptColors(
    black = Black,
    gray1 = Gray1,
    gray2 = Gray2,
    gray3 = Gray3,
    gray5 = Gray5,
    gray6 = Gray6,
    red = Red,
    white = White,
)

val LocalPlaySoptColorsProvider = staticCompositionLocalOf { defaultPlaySoptColors }