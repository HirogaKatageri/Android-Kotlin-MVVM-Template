package com.silverlotus.kmvvm.base

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector

/**
 * Created by Gian Patrick Quintana on 2/23/2018.
 */
abstract class BaseRepository<out T> : KodeinInjected {

    override val injector: KodeinInjector = KodeinInjector()

    @Suppress("UNCHECKED_CAST")
    fun init(kodein: Kodein): T {
        injector.inject(kodein)
        return this as T
    }

}