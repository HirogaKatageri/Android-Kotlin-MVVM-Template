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

    /**
     * Initiate bindings here.
     *
     * bind<Type>() with singleton { Type() }
     *
     * @see <a href="https://salomonbrys.github.io/Kodein/#_bindings_declaring_dependencies">Kodein Declaring Dependencies</a>
     * */
    override val kodein by Kodein.lazy {

        bind<FuelManager>() with singleton { FuelManager.instance }//Just a simple example of a type of binding. PS: Currently useless since we're using FuelRouting.
    }

    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
    }
}