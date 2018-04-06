package com.silverlotus.kmvvm.base

import android.arch.lifecycle.ViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger

/**
 * Created by Gian Patrick Quintana on 2/23/2018.
 */
abstract class BaseViewModel<out T> : ViewModel(), KodeinAware {

    override lateinit var kodein: Kodein
    override val kodeinTrigger: KodeinTrigger = KodeinTrigger()

    @Suppress("UNCHECKED_CAST")
    fun init(kodein: Kodein): T {

        this.kodein = kodein
        kodeinTrigger.trigger()
        return this as T
    }

}