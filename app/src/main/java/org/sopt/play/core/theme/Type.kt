package org.sopt.play.core.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.sopt.play.R
import androidx.compose.ui.text.TextStyle

object PretendardFont {
    val Bold = FontFamily(Font(R.font.pretendard_bold))
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
}

@Immutable
class PlaySoptTypography(
    val b28: TextStyle,
    val m18: TextStyle,
    val sb16: TextStyle,
    val m14: TextStyle,
    val sb14: TextStyle,
)

val defaultPlaySoptTypography = PlaySoptTypography(
    b28 = TextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 28.sp,
        lineHeight = 33.6.sp, // 120%
        letterSpacing = (-0.28).sp, // -1%
    ),
    m18 = TextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 18.sp,
        lineHeight = 21.6.sp, // 120%
        letterSpacing = (-0.18).sp, // -1%
    ),
    sb16 = TextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 16.sp,
        lineHeight = 19.2.sp, // 120%
        letterSpacing = (-0.16).sp, // -1%
    ),
    m14 = TextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 14.sp,
        lineHeight = 16.8.sp, // 120%
        letterSpacing = (-0.14).sp, // -1%
    ),
    sb14 = TextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.8.sp, // 120%
        letterSpacing = (-0.14).sp, // -1%
    ),
)

val LocalPlaySoptTypographyProvider = staticCompositionLocalOf { defaultPlaySoptTypography }