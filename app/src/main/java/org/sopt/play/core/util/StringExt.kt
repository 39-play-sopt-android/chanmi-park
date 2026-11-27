package org.sopt.play.core.util

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

private const val SERVER_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss"
private const val DOT_DATE_PATTERN = "yyyy.MM.dd"
private const val UTC = "UTC"
private const val KST = "Asia/Seoul"

fun String.toDotDate(): String {
    val serverFormat = SimpleDateFormat(SERVER_DATE_PATTERN, Locale.KOREA).apply {
        timeZone = TimeZone.getTimeZone(UTC)
    }
    val dotFormat = SimpleDateFormat(DOT_DATE_PATTERN, Locale.KOREA).apply {
        timeZone = TimeZone.getTimeZone(KST)
    }

    val date = runCatching { serverFormat.parse(substringBefore(".")) }.getOrNull()
        ?: return take(10).replace("-", ".")

    return dotFormat.format(date)
}
