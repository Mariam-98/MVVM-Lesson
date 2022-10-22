package com.example.mvvmlesson.domain.news

import com.example.mvvmlesson.model.news.NewsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("search?")
    fun getNews(
        @Query("api-key") apiKey: String = API_KEY,
        @Query("show-fields") showFields: String
    ): Call<NewsDto>

    companion object {
        private const val API_KEY = "e7caa497-5e2a-4e3d-b10f-7194654bc44e"
    }
}