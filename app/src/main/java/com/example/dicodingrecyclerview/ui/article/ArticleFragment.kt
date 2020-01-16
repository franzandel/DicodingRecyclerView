package com.example.dicodingrecyclerview.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.dicodingrecyclerview.R
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment() {

    private lateinit var articleViewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVM()
        setupUI()
    }

    private fun initializeVM() {
        val safeArgs: ArticleFragmentArgs by navArgs()
        val article = safeArgs.specificArticle
        val viewModelFactory = ArticleViewModelFactory(article)
        articleViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ArticleViewModel::class.java)
    }

    private fun setupUI() {
        articleViewModel.apply {
            articleImageURL.observe(this@ArticleFragment, Observer { imageURL ->
                Glide.with(this@ArticleFragment).load(imageURL).into(ivNews)
            })

            articleTitle.observe(this@ArticleFragment, Observer { title ->
                tvTitle.text = title
            })

            articleSourceName.observe(this@ArticleFragment, Observer { sourceName ->
                tvSource.text = sourceName
            })

            articleAuthor.observe(this@ArticleFragment, Observer { author ->
                tvAuthor.text = author
            })

            articlePublishedDate.observe(this@ArticleFragment, Observer { publishedDate ->
                tvPublishedDate.text = publishedDate
            })

            articleContent.observe(this@ArticleFragment, Observer { content ->
                tvContent.text = content
            })

            articleURL.observe(this@ArticleFragment, Observer { url ->
                tvURL.text = url
            })
        }
    }
}
