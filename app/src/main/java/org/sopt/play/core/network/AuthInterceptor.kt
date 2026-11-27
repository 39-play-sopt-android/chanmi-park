package org.sopt.play.core.network

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import org.sopt.play.data.local.datasource.api.LocalTokenDataSource
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val localTokenDataSource: LocalTokenDataSource,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val authorizationCode = runBlocking { localTokenDataSource.getAuthorizationCode() }

        val request = chain.request().newBuilder()
            .apply {
                if (!authorizationCode.isNullOrBlank()) {
                    header(AUTHORIZATION, authorizationCode)
                }
            }
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
    }
}
