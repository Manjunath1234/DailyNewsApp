package com.example.dailynewsapp.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailynewsapp.domain.use_case.GetNewsArticleUseCase
import com.example.dailynewsapp.presentation.ArticleStateHolder
import com.example.dailynewsapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) :
    ViewModel() {

    val articles = mutableStateOf(ArticleStateHolder())

    init {
        getNewsArticles()
    }

    fun getNewsArticles() {
        getNewsArticleUseCase().onEach {
            when (it) {
                is Result.Error -> articles.value =
                    ArticleStateHolder(error = it.message.toString())

                is Result.Loading -> articles.value = ArticleStateHolder(isLoading = true)
                is Result.Success -> articles.value = ArticleStateHolder(data = it.data)
            }
        }.launchIn(viewModelScope)
    }

}