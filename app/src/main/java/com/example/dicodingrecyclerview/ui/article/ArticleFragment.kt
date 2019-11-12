package com.example.dicodingrecyclerview.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide

import com.example.dicodingrecyclerview.R
import com.example.dicodingrecyclerview.data.entities.Article
import com.example.dicodingrecyclerview.ui.news.NewsFragment.Companion.ARTICLE_KEY

class ArticleFragment : Fragment() {

    private lateinit var ivNews: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvSource: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvPublishedDate: TextView
    private lateinit var tvContent: TextView
    private lateinit var tvURL: TextView
    private lateinit var articleViewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewId(view)
        initializeVM()
        setupUI()
    }

    private fun setupViewId(view: View) {
        ivNews = view.findViewById(R.id.ivNews)
        tvTitle = view.findViewById(R.id.tvTitle)
        tvSource = view.findViewById(R.id.tvSource)
        tvAuthor = view.findViewById(R.id.tvAuthor)
        tvPublishedDate = view.findViewById(R.id.tvPublishedDate)
        tvContent = view.findViewById(R.id.tvContent)
        tvURL = view.findViewById(R.id.tvURL)
    }

    private fun initializeVM() {
        val article = arguments?.getParcelable<Article>(ARTICLE_KEY)
        val viewModelFactory = ArticleViewModelFactory(article!!)
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
