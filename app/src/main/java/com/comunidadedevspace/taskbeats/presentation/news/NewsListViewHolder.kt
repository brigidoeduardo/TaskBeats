package com.comunidadedevspace.taskbeats.presentation.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.local.News

class NewsListViewHolder (
    private val view: View
) : RecyclerView.ViewHolder(view) {
    private val tvNewsTitle = view.findViewById<TextView>(R.id.tvNewsTitle)
    private val imgNews = view.findViewById<ImageView>(R.id.imgNews)

    fun bind (
        news: News
    ){
        tvNewsTitle.text = news.title
        imgNews.load(news.imgUrl){
            transformations(RoundedCornersTransformation(12f))
        }
    }
}
