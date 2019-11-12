package com.example.dicodingrecyclerview.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.dicodingrecyclerview.R

class AboutFragment : Fragment() {

    private lateinit var ivAbout: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView
    private lateinit var aboutViewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeVM()
        setupViewId(view)
        setupUI()
    }

    private fun initializeVM() {
        aboutViewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)
    }

    private fun setupViewId(view: View) {
        ivAbout = view.findViewById(R.id.ivAbout)
        tvName = view.findViewById(R.id.tvName)
        tvEmail = view.findViewById(R.id.tvEmail)
    }

    private fun setupUI() {
        Glide.with(this)
            .load(R.mipmap.ic_about_image_foreground)
            .circleCrop()
            .into(ivAbout)


        aboutViewModel.name.observe(this, Observer {
            tvName.text = it
        })


        aboutViewModel.email.observe(this, Observer {
            tvEmail.text = it
        })
    }
}