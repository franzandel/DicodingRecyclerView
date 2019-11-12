package com.example.dicodingrecyclerview.ui.news

import com.bumptech.glide.Glide
import com.example.dicodingrecyclerview.R
import com.example.dicodingrecyclerview.data.entities.Article
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.news_row.view.*

/**
 * Created by Franz Andel on 2019-11-10.
 * Android Engineer
 */

class NewsRow(val article: Article): Item<ViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.news_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            Glide.with(context)
                .load(getUrl())
                .placeholder(R.mipmap.ic_image_not_found_foreground)
                .into(ivNews)

            tvNewsTitle.text = article.title

            val description = article.description.toString()
            tvNewsSubTitle.text = if (description.length > 84) description.substring(0, 84) else description
        }
    }

    private fun getUrl(): String {
        val splitUrl = article.urlToImage?.split(":")
        var url = article.urlToImage.toString()
        if (splitUrl != null) {
            if (splitUrl[0] != "https") {
                url = "https:" + splitUrl[1]
                return url
            }
        }

        return url
    }
}