package com.silverlotus.kmvvm.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kodeinTrigger.trigger()
    }

}