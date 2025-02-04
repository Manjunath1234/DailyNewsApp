package com.example.dailynewsapp.domain.di

import com.example.dailynewsapp.data.network.ApiService
import com.example.dailynewsapp.data.repository.GetNewsArticleRepoImpl
import com.example.dailynewsapp.domain.repository.GetNewsArticlesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideGetNewsRepo(apiService: ApiService): GetNewsArticlesRepo {
        return GetNewsArticleRepoImpl(apiService = apiService)
    }
}