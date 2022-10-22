package com.example.mvvmlesson.ui.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import com.bumptech.glide.Glide
import com.example.mvvmlesson.R
import com.example.mvvmlesson.model.news.Result
import com.example.mvvmlesson.ui.news.NewsMainFragment.Companion.CLICKED_NEWS
import java.text.SimpleDateFormat

class NewsDetailsFragment : Fragment() {

    private lateinit var newsDetailsImageView: ImageView
    private lateinit var newsDetailsSectionName: TextView
    private lateinit var newsDetailsBody: TextView
    private lateinit var newsDetailsWebPublicationDate: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsDetailsImageView = view.findViewById(R.id.newsDetailsImageView)
        newsDetailsSectionName = view.findViewById(R.id.newsDetailsSectionName)
        newsDetailsBody = view.findViewById(R.id.newsDetailsBody)
        newsDetailsWebPublicationDate = view.findViewById(R.id.newsDetailsWebPublicationDate)

        setupViews()
    }

    @SuppressLint("SimpleDateFormat")
    private fun setupViews() {
        val clickedNews = arguments?.getSerializable(CLICKED_NEWS) as? Result

        Glide.with(requireActivity()).load(clickedNews?.fields?.thumbnail).into(newsDetailsImageView)

        newsDetailsSectionName.text = clickedNews?.sectionName

        newsDetailsBody.text = clickedNews?.fields?.body?.let {
            HtmlCompat.fromHtml(it, FROM_HTML_MODE_LEGACY)
        }

        newsDetailsBody.movementMethod = LinkMovementMethod()

        newsDetailsWebPublicationDate.text = clickedNews?.webPublicationDate?.let {
            SimpleDateFormat("yyyy.mm.dd hh:mm:ss").format(
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(it) ?: return)
        }
    }
}