package com.silverlotus.kmvvm.root

import android.app.Application
import android.arch.persistence.room.Room
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.android.appKodein
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.silverlotus.api.Api
import com.silverlotus.kmvvm.repository.MangaRepository
import com.silverlotus.kmvvm.room.AppDatabase
import com.silverlotus.kmvvm.room.dao.MangaDao

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class App : Application(), KodeinAware {

    /**
     * This is where we create those bindings a.k.a Dependency Injections.
     * Below you can see I have 3 types of bindings.
     * I also initialized my Room Database within it.
     * You can explore more details about Kodein and dependency injection with the link below.
     *
     * https://salomonbrys.github.io/Kodein/#_bindings_declaring_dependencies
     * */
    override val kodein by Kodein.lazy {

        val database: AppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app.db")
                .allowMainThreadQueries()
                .build()

        bind<MangaDao>() with singleton { database.mangaListDao() }
        bind<MangaRepository>() with singleton { MangaRepository().init(appKodein()) }
        bind<Api>() with singleton { Api() }
    }

    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
    }
}