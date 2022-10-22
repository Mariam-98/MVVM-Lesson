package com.example.mvvmlesson.domain.news

import com.example.mvvmlesson.model.news.NewsDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface NewsSharedRepository {
    fun getNewsResponse(baseResponseListener: BaseResponseListener<NewsDto?>)
}

class NewsSharedRepositoryImpl(private val newsApiService: NewsApiService) : NewsSharedRepository {

    override fun getNewsResponse(baseResponseListener: BaseResponseListener<NewsDto?>) {
        val call = newsApiService.getNews(showFields = "body,thumbnail")
        call.enqueue(object : Callback<NewsDto> {
            override fun onResponse(call: Call<NewsDto>, response: Response<NewsDto>) {
                baseResponseListener.onResponseSuccess(response.body())
            }

            override fun onFailure(call: Call<NewsDto>, t: Throwable) {
                baseResponseListener.onResponseFailure(t)
            }
        })
    }
}

interface BaseResponseListener<T> {
    fun onResponseSuccess(response: T)
    fun onResponseFailure(t: Throwable)
}