package com.example.mvvmlesson.di

import com.example.mvvmlesson.ui.news.viewModels.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<NewsViewModel>(){
        NewsViewModel()
    }
}