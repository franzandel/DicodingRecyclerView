package com.example.dicodingrecyclerview.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    val id: String ?= null,
    val name: String
) : Parcelable