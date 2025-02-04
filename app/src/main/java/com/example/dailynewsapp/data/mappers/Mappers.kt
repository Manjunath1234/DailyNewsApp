package com.example.dailynewsapp.data.mappers

import com.example.dailynewsapp.data.model.ArticleResponse
import com.example.dailynewsapp.domain.model.Article

fun List<ArticleResponse>.toDomain():List<Article>{
    return map{
        Article(
            author = it.author?:"",
            description = it.description?:"",
            title = it.title?:"",
            urlToImage = it.urlToImage?:""
        )
    }
}