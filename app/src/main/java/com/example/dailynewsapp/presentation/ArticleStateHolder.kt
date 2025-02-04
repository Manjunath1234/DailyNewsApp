package com.example.dailynewsapp.presentation

import com.example.dailynewsapp.domain.model.Article

data class ArticleStateHolder(
    val isLoading :Boolean =false,
    val data :List<Article>? = null,
    val error :String = ""
)
