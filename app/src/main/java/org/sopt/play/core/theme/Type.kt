package org.sopt.play.core.theme

import android.R.attr.letterSpacing
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.sopt.play.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em

object PretendardFont {
    val Bold = FontFamily(Font(R.font.pretendard_bold))
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
}

@Immutable
data class PlaySoptTypography(
    val b28: TextStyle,
    val m18: TextStyle,
    val sb16: TextStyle,
    val m14: TextStyle,
    val sb14: TextStyle,
)

private fun PlaySoptTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = 1.2.em,
    letterSpacing = (-0.01.em),
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    )
)

val defaultPlaySoptTypography = PlaySoptTypography(
    b28 = PlaySoptTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 28.sp,
    ),
    m18 = PlaySoptTextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 18.sp,
    ),
    sb16 = PlaySoptTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 16.sp,
    ),
    m14 = PlaySoptTextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 14.sp,
    ),
    sb14 = PlaySoptTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 14.sp,
    ),
)
