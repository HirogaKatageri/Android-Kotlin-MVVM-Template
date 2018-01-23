package com.silverlotus.kmvvm.root

import android.app.Application
import com.github.kittinunf.fuel.core.FuelManager
import com.github.salomonbrys.kodein.*
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class App : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        /**
         * Initiate bindings here.
         *
         * bind<Type>() with singleton { Type() }
         *
         * @link https://salomonbrys.github.io/Kodein/#_bindings_declaring_dependencies
         * */

        val manager:FuelManager =  FuelManager.instance
        manager.basePath = "https://com.silverlotus.kmvvm.api.ipify.org"

        bind<FuelManager>() with singleton { manager }
    }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}