package com.comunidadedevspace.taskbeats.presentation.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.local.News

class NewsListFragment : Fragment() {

    private val adapter = NewsListAdapter()

    private val viewModel by lazy {
        NewsListViewModel.create()
    }
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvNews = view.findViewById<RecyclerView>(R.id.rvNews)
        rvNews.adapter = adapter

        viewModel.newsListLiveData.observe(viewLifecycleOwner){ newsListDto ->
            val newsList = newsListDto.map { newsDto ->
                News (
                    title = newsDto.title,
                    imgUrl = newsDto.imageUrl
                )
            }
            adapter.submitList(newsList)
        }

    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = NewsListFragment()
    }
}