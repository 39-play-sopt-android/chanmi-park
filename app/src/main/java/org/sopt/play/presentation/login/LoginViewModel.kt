package org.sopt.play.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.play.data.repository.api.auth.AuthRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun login(
        isRegisteredUser: (String, String) -> Boolean,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        val state = _uiState.value
        if (!isRegisteredUser(state.email, state.password)) {
            onFailure("이메일 또는 비밀번호가 올바르지 않아요.")
            return
        }

        viewModelScope.launch {
            authRepository.issueAuthorizationCode()
                .onSuccess { onSuccess() }
                .onFailure { onFailure(it.message.orEmpty()) }
        }
    }
}
