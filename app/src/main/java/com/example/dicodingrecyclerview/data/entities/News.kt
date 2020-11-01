package com.example.dicodingrecyclerview.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    var articles: List<Article>,
    var status: String? = null,
    var totalResults: Int? = null
) : Parcelable