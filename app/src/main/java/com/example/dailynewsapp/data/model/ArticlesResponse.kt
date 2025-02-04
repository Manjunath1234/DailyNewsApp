package com.example.dailynewsapp.data.model

data class ArticlesResponse(
    val articles: List<ArticleResponse>?,
    val status: String?,
    val totalResults: Int?
)