package org.sopt.play.presentation.register

import android.util.Patterns

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val passwordCheck: String = "",
) {
    val isNameValid: Boolean
        get() = name.isNotBlank()

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    val isPasswordValid: Boolean
        get() = password.length >= 6

    val isPasswordCheckValid: Boolean
        get() = password == passwordCheck

    val isRegisterEnabled: Boolean
        get() = isNameValid && isEmailValid && isPasswordValid && isPasswordCheckValid
}
