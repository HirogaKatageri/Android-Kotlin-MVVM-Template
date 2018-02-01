package com.silverlotus.kmvvm.root

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
open class RootFragment : Fragment(), KodeinInjected {

    override val injector = KodeinInjector()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inject(appKodein())
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}