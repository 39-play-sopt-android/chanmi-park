package org.sopt.play.data.di.post

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.play.data.service.PostService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostServiceModule {
    @Provides
    @Singleton
    fun providePostService(
        retrofit: Retrofit
    ): PostService = retrofit.create()
}
