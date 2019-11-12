package com.example.dicodingrecyclerview.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "Franz Andel"
    }
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>().apply {
        value = "franz_andel@yahoo.com"
    }
    val email: LiveData<String> = _email
}