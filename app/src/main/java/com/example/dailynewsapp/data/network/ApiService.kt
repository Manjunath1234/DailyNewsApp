package com.example.dailynewsapp.data.network

import com.example.dailynewsapp.data.model.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us", @Query("apikey") apikey: String =""
    ):Response<ArticlesResponse>

}