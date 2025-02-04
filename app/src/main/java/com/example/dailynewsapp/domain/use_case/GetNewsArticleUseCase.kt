package com.example.dailynewsapp.domain.use_case

import com.example.dailynewsapp.domain.model.Article
import com.example.dailynewsapp.domain.repository.GetNewsArticlesRepo
import com.example.dailynewsapp.utils.Result;
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class GetNewsArticleUseCase @Inject constructor(private val getNewsArticlesRepo: GetNewsArticlesRepo){

    operator fun invoke() : Flow<Result<List<Article>>> = flow {
        emit(Result.Loading(""))
        try {
            emit(Result.Success(getNewsArticlesRepo.getNewsArticles()))
        }catch (e :Exception){
            emit(Result.Error(e.message))
        }
    }
}