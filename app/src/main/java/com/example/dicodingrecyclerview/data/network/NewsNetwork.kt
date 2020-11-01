package com.example.dicodingrecyclerview.data.network

import com.example.dicodingrecyclerview.BuildConfig
import com.example.dicodingrecyclerview.data.entities.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Franz Andel on 2019-11-10.
 * Android Engineer
 */

class NewsNetwork {

    interface NewsNetworkService {
        @GET("/v2/top-headlines")
        fun getAllNews(
            @Query("apiKey") apiKey: String = BuildConfig.API_KEY_GITHUB,
            @Query("country") country: String = "us",
            @Query("category") category: String = "business"
        ): Call<News>
    }

    fun getNewsNetworkService(): NewsNetworkService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_GITHUB)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NewsNetworkService::class.java)
    }
}