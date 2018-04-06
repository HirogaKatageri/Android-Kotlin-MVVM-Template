package com.silverlotus.kmvvm.base

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.silverlotus.api.Api
import com.silverlotus.kmvvm.repository.MangaRepository
import com.silverlotus.kmvvm.room.AppDatabase
import com.silverlotus.kmvvm.room.dao.MangaDao
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        val database: AppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app.db")
                .allowMainThreadQueries()
                .build()

        bind<MangaDao>() with singleton { database.mangaListDao() }
        bind<MangaRepository>() with singleton { MangaRepository(applicationContext) }
        bind<Api>() with singleton { Api() }
        bind<SharedPreferences>() with instance(getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE))
    }

//    override val kodein by Kodein.lazy {
//
//        val database: AppDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app.db")
//                .allowMainThreadQueries()
//                .build()
//
//        bind<MangaDao>() with singleton { database.mangaListDao() }
//        bind<MangaRepository>() with singleton { MangaRepository().init(appKodein()) }
//        bind<Api>() with singleton { Api() }
//    }

    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
    }
}