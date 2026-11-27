package org.sopt.play.data.di.post

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.play.data.datasource.api.post.PostDataSource
import org.sopt.play.data.datasource.impl.post.PostDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsPostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource
}
