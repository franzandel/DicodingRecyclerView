package com.example.dicodingrecyclerview.ui.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dicodingrecyclerview.data.entities.Article
import java.lang.IllegalArgumentException

/**
 * Created by Franz Andel on 2019-11-12.
 * Android Engineer
 */

class ArticleViewModelFactory(private val article: Article): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(article) as T
        }

        throw IllegalArgumentException("Unknown View Model class")
    }
}