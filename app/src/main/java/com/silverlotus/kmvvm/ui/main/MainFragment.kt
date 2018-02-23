package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import com.github.salomonbrys.kodein.android.appKodein
import com.orhanobut.logger.Logger
import com.silverlotus.kmvvm.BR
import com.silverlotus.kmvvm.R
import com.silverlotus.kmvvm.databinding.ItemMangaBinding
import com.silverlotus.kmvvm.room.entity.MangaEntity
import com.silverlotus.kmvvm.root.RootFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainFragment : RootFragment(), MainView {

    private lateinit var model: MainViewModel
    private lateinit var lastAdapter: LastAdapter
    private val adapterList = arrayListOf<Any>()

    private val typeMangaEntity = Type<ItemMangaBinding>(R.layout.item_manga)
            .onClick { item ->
                Logger.d(item.binding.item?.toString())
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java).init(appKodein())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerMangaTitles.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        lastAdapter = LastAdapter(adapterList, BR.item)
                .type { item, _ ->
                    when (item) {
                        is MangaEntity -> typeMangaEntity
                        else -> null
                    }
                }
                .into(recyclerMangaTitles)

        buttonGetMangas.setOnClickListener {
            showProgressBar()

            if (model.isFirstLoad) {

                model.getMangaList().observe(this, Observer { list ->

                    if (list != null) {
                        adapterList.clear()
                        adapterList.addAll(list)
                        lastAdapter.notifyDataSetChanged()
                    }

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