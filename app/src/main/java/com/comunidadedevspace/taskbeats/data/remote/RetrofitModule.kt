package com.comunidadedevspace.taskbeats.data.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    fun createNewsService(): NewsService {
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.thenewsapi.com/v1/news/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofit
            .create(NewsService::class.java)
    }
}