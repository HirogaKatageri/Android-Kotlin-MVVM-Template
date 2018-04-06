package com.silverlotus.kmvvm.base

import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

/**
 * Created by Gian Patrick Quintana on 2/23/2018.
 */
abstract class BaseRepository<out T>(context: Context) : KodeinAware {

    override val kodein: Kodein by closestKodein(context)
    override val kodeinTrigger: KodeinTrigger = KodeinTrigger()

    @Suppress("UNCHECKED_CAST")
    fun init(): T {

        kodeinTrigger.trigger()
        return this as T
    }

}