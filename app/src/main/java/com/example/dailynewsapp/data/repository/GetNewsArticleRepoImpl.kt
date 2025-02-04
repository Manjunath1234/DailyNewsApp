package com.example.dailynewsapp.data.repository



import com.example.dailynewsapp.BuildConfig
import com.example.dailynewsapp.data.mappers.toDomain
import com.example.dailynewsapp.data.network.ApiService
import com.example.dailynewsapp.domain.model.Article
import com.example.dailynewsapp.domain.repository.GetNewsArticlesRepo
import com.example.dailynewsapp.utils.SafeApiRequest

import javax.inject.Inject

class GetNewsArticleRepoImpl @Inject constructor(private val apiService: ApiService): GetNewsArticlesRepo,
    SafeApiRequest() {
    override suspend fun getNewsArticles(): List<Article> {
        val response = safeApiRequest {
            apiService.getNewsArticles(apikey = BuildConfig.API_KEY)
        }
        return response.articles?.toDomain()!!
    }
}