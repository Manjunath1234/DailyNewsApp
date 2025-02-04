package com.example.dailynewsapp.domain.repository

import com.example.dailynewsapp.domain.model.Article

interface GetNewsArticlesRepo {
    suspend fun getNewsArticles(): List<Article>
}