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
     * Initiate bindings here.
     *
     * bind<Type>() with singleton { Type() }
     *
     * @see <a href="https://salomonbrys.github.io/Kodein/#_bindings_declaring_dependencies">Kodein Declaring Dependencies</a>
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