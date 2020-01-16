package com.example.dicodingrecyclerview.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingrecyclerview.data.repository.AppRepository

class NewsViewModel : ViewModel() {

    private val appRepository = AppRepository()

    private val mutableLiveData = MutableLiveData<List<NewsRow>>()

    fun setListNewsRow() {
        appRepository.getAllNews().observeForever { news ->
            val articlesCopy = news.articles.map { article ->
                NewsRow(article)
            }

            val distinctArticles = articlesCopy.distinctBy { newsRow ->
                newsRow.article.source?.name
            }

            mutableLiveData.postValue(distinctArticles)
        }
    }

    fun getListNewsRow(): LiveData<List<NewsRow>> {
        return mutableLiveData
    }
}