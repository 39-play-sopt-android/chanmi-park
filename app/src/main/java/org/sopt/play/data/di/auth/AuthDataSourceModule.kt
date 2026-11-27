package org.sopt.play.data.di.auth

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.play.data.datasource.api.auth.AuthDataSource
import org.sopt.play.data.datasource.impl.auth.AuthDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsAuthDataSource(
        authDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource
}
