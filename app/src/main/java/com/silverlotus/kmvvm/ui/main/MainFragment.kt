package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silverlotus.kmvp.R
import com.silverlotus.kmvvm.data.Ip
import com.silverlotus.kmvvm.root.RootFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainFragment : RootFragment(), MainView {

    private lateinit var model: MainViewModel

    private val ipObserver = Observer<String> {
        textIp.text = it
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        model.attach(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRetrieveIp.setOnClickListener {
            model.fetchMyIp().observe(this, ipObserver)
        }
    }

    override fun showIp(ip: Ip?) {
    }
}