package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silverlotus.kmvvm.R
import com.silverlotus.kmvvm.root.RootFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainFragment : RootFragment(), MainView {

    private lateinit var model: MainViewModel

    /**
     * Observer for our ViewModel IpAddress LiveData value.
     * @see Observer.onChanged
     * */
    private val ipObserver = Observer<String> {
        textIp.text = it
        hideProgressBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater?.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRetrieveIp.setOnClickListener {
            showProgressBar()
            model.fetchMyIp().observe(this, ipObserver) //Here we attach our ipObserver
        }
    }

    override fun showProgressBar() {

        textIp.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {

        progressBar.visibility = View.GONE
        textIp.visibility = View.VISIBLE
    }
}