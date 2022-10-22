package com.example.mvvmlesson.ui.news.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmlesson.domain.base.createNewsApiService
import com.example.mvvmlesson.domain.news.BaseResponseListener
import com.example.mvvmlesson.domain.news.NewsSharedRepositoryImpl
import com.example.mvvmlesson.model.news.NewsDto
import com.example.mvvmlesson.model.news.Result

class NewsViewModel : ViewModel() {

    private val repository = NewsSharedRepositoryImpl(createNewsApiService())

    private val _newsLiveData = MutableLiveData<List<Result>?>()
    val newsLiveData: LiveData<List<Result>?>
        get() = _newsLiveData

    fun getAllNews() {
        repository.getNewsResponse(object : BaseResponseListener<NewsDto?> {
            override fun onResponseSuccess(response: NewsDto?) {
                _newsLiveData.value = response?.response?.results
            }

            override fun onResponseFailure(t: Throwable) {
                Log.d("onResponseFailure", t.message.toString())
            }
        })
    }
}