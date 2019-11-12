package com.example.dicodingrecyclerview.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingrecyclerview.R
import com.github.ybq.android.spinkit.SpinKitView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private var newsAdapter = GroupAdapter<ViewHolder>()
    private lateinit var rvNews: RecyclerView
    private lateinit var spinKitProgress: SpinKitView

    companion object {
        const val ARTICLE_KEY = "article_key"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVM()
        setupViewId(view)
        setupRecyclerView(view)
        setupUI()
        setupClickListener()
    }

    private fun initializeVM() {
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
    }

    private fun setupViewId(view: View) {
        rvNews = view.findViewById(R.id.rvNews)
        spinKitProgress = view.findViewById(R.id.spinKitProgress)
    }

    private fun setupUI() {
        newsViewModel.getListNewsRow().observe(this, Observer { listNewsRow ->
            spinKitProgress.visibility = View.GONE
            newsAdapter.addAll(listNewsRow)
            rvNews.adapter = newsAdapter
        })
    }

    private fun setupRecyclerView(view: View) {
        rvNews.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setupClickListener() {
        newsAdapter.setOnItemClickListener { item, _ ->
            val newsRow = item as NewsRow

            val bundle = Bundle().apply {
                putParcelable(ARTICLE_KEY, newsRow.article)
            }

            findNavController().navigate(R.id.navigation_article, bundle)
        }
    }
}