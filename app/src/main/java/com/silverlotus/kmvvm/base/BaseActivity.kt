package com.silverlotus.kmvvm.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), KodeinInjected {

    override val injector = KodeinInjector()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(appKodein())
    }

}