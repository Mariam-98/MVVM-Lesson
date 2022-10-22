package com.example.mvvmlesson.domain.base

import com.example.mvvmlesson.domain.news.NewsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NEWS_BASE_URL = "https://content.guardianapis.com/"

private fun createRetrofitClient(baseUrl: String): Retrofit = Retrofit.Builder().baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClient()).build()

private fun <T> createWebService(apiService: Class<T>): T = createRetrofitClient(NEWS_BASE_URL).create(apiService)

fun createNewsApiService(): NewsApiService = createWebService(NewsApiService::class.java)