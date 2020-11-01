package com.example.dicodingrecyclerview.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.dicodingrecyclerview.data.entities.News
import com.example.dicodingrecyclerview.data.network.NewsNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Franz Andel on 2019-11-10.
 * Android Engineer
 */

class AppRepository {
    private val newsNetworkService = NewsNetwork().getNewsNetworkService()

    fun getAllNews(): MutableLiveData<News> {
        val mutableLiveData = MutableLiveData<News>()

        newsNetworkService.getAllNews()
            .enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val news = response.body()
                    mutableLiveData.value = news
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    t.printStackTrace()
                }
            })

        return mutableLiveData
    }
}