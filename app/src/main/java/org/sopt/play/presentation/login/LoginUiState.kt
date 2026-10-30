package org.sopt.play.presentation.login

import android.util.Patterns

data class LoginUiState(
    val email: String = "",
    val password: String = "",
) {
    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    val isPasswordValid: Boolean
        get() = password.length >= 6

    val isLoginEnabled: Boolean
        get() = isEmailValid && isPasswordValid
}
