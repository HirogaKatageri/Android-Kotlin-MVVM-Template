package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.android.appKodein
import com.silverlotus.kmvvm.R
import com.silverlotus.kmvvm.adapter.MangaAdapter
import com.silverlotus.kmvvm.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainFragment : BaseFragment(), MainView {

    private lateinit var model: MainViewModel
    private val adapter = MangaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java).init(appKodein())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerMangaTitles.adapter = adapter
        recyclerMangaTitles.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        buttonGetMangas.setOnClickListener {
            showProgressBar()

            if (model.isFirstLoad) {

                model.getMangaList().observe(this, Observer { list ->

                    adapter.submitList(list)
                    hideProgressBar()
                })

                model.fetchMangaList()
                model.isFirstLoad = false
            } else
                model.fetchMangaList()

        }
    }

    override fun showProgressBar() {

        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {

        progressBar.visibility = View.GONE
    }
}