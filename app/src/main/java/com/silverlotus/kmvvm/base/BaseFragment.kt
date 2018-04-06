package com.silverlotus.kmvvm.base

import android.os.Bundle
import android.support.v4.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
abstract class BaseFragment : Fragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kodeinTrigger.trigger()
    }
}