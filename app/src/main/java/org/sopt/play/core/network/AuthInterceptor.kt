package org.sopt.play.core.network

import okhttp3.Interceptor
import okhttp3.Response
import org.sopt.play.data.local.TokenStorage
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenStorage: TokenStorage,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val authorizationCode = tokenStorage.authorizationCode
            ?: return chain.proceed(chain.request())

        val request = chain.request().newBuilder()
            .header(AUTHORIZATION, authorizationCode)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
    }
}
