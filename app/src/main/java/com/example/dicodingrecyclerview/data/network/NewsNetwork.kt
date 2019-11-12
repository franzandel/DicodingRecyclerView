package com.example.dicodingrecyclerview.data.network

import com.example.dicodingrecyclerview.external.AppConst.baseUrl
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
        @GET("/v2/top-headlines?country=us&category=business")
        fun getAllNews(@Query("apiKey") apiKey: String): Call<News>
    }

    fun getNewsNetworkService(): NewsNetworkService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(NewsNetworkService::class.java)
    }
}