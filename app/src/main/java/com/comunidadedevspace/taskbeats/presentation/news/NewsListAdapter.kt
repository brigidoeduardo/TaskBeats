package com.comunidadedevspace.taskbeats.presentation.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.local.News

class NewsListAdapter : ListAdapter <News, NewsListViewHolder> (NewsListAdapter){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val view : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_news, parent,false)
        return NewsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    companion object : DiffUtil.ItemCallback <News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.title == newItem.title &&
                    oldItem.imgUrl == newItem.imgUrl
        }
    }

}

