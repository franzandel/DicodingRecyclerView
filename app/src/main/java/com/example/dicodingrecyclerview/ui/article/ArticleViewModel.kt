package com.example.dicodingrecyclerview.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingrecyclerview.data.entities.Article
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Franz Andel on 2019-11-12.
 * Android Engineer
 */

class ArticleViewModel(article: Article) : ViewModel() {

    private val _articleImageURL = MutableLiveData<String>().apply {
        value = article.urlToImage
    }
    val articleImageURL: LiveData<String> = _articleImageURL

    private val _articleTitle = MutableLiveData<String>().apply {
        value = article.title
    }
    val articleTitle: LiveData<String> = _articleTitle

    private val _articleSourceName = MutableLiveData<String>().apply {
        value = article.source?.name
    }
    val articleSourceName:LiveData<String> = _articleSourceName

    private val _articleAuthor = MutableLiveData<String>().apply {
        value = article.author
    }
    val articleAuthor: LiveData<String> = _articleAuthor

    private val _articlePublishedDate = MutableLiveData<String>().apply {
        value = getFormattedDate(article.publishedAt)
    }
    val articlePublishedDate: LiveData<String> = _articlePublishedDate

    private val _articleContent = MutableLiveData<String>().apply {
        value = article.content
    }
    val articleContent: LiveData<String> = _articleContent

    private val _articleURL = MutableLiveData<String>().apply {
        value = article.url
    }
    val articleURL: LiveData<String> = _articleURL

    private fun getFormattedDate(unformattedDate: String?): String {
        return try {
            val apiDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            val date = apiDateFormat.parse(unformattedDate!!)
            val desiredFormat = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
            desiredFormat.format(date?.toString())
        } catch (e: Exception) {
            "-"
        }
    }
}