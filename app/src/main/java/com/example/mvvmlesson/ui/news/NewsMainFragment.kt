package com.example.mvvmlesson.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlesson.R
import com.example.mvvmlesson.ui.news.adapters.NewsAdapter
import com.example.mvvmlesson.ui.news.viewModels.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsMainFragment : Fragment() {

    private val newsViewModel by viewModel<NewsViewModel>()

    private val newsAdapter = NewsAdapter { clickedNews ->
        requireActivity().supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.container, NewsDetailsFragment::class.java, Bundle().apply {
                putSerializable(CLICKED_NEWS, clickedNews)
                Log.d("checking", clickedNews.fields?.thumbnail.toString())
            }).commit()
    }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsViewModel.getAllNews()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
    }

    private fun setupViews() {
        recyclerView = requireView().findViewById(R.id.newsRecyclerView)
        recyclerView.adapter = newsAdapter
    }

    private fun observeLiveData() {
        newsViewModel.newsLiveData.observe(requireActivity()) {
            newsAdapter.setNewsList(it)
        }
    }

    companion object {
        const val CLICKED_NEWS = "clickedNews"
    }
}