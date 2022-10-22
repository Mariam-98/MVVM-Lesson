package com.example.mvvmlesson.ui.news.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmlesson.R
import com.example.mvvmlesson.model.news.Result

class NewsAdapter(val onItemClick: (Result) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList = mutableListOf<Result>()
    private lateinit var context: Context

    @SuppressLint("NotifyDataSetChanged")
    fun setNewsList(newNewsList: List<Result>?) {
        newsList.clear()
        newNewsList?.let { newsList.addAll(it) }
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int = newsList.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val newsImageView: ImageView = itemView.findViewById(R.id.newsImageView)
        private val newsSectionName: TextView = itemView.findViewById(R.id.newsSectionName)
        private val newsWebPublicationDate: TextView = itemView.findViewById(R.id.newsWebPublicationDate)

        init {
            itemView.setOnClickListener{
                onItemClick(newsList[adapterPosition])
            }
        }

        fun bind() {
            newsSectionName.text = newsList[adapterPosition].sectionName
            newsWebPublicationDate.text = newsList[adapterPosition].webPublicationDate
            Glide.with(context).load(newsList[adapterPosition].fields?.thumbnail).circleCrop().into(newsImageView)
        }

    }
}