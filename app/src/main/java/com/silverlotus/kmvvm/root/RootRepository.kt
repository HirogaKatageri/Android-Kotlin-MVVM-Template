package com.silverlotus.kmvvm.root

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector

/**
 * Created by Gian Patrick Quintana on 2/23/2018.
 */
abstract class RootRepository<out T> : KodeinInjected {

    override val injector: KodeinInjector = KodeinInjector()

    @Suppress("UNCHECKED_CAST")
    fun init(kodein: Kodein): T {
        injector.inject(kodein)
        return this as T
    }

}