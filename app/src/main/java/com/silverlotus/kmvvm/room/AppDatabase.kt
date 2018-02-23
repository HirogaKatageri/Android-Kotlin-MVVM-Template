package com.silverlotus.kmvvm.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.silverlotus.kmvvm.room.dao.MangaDao
import com.silverlotus.kmvvm.room.entity.MangaEntity

/**
 * Created by Gian Patrick Quintana on 2/21/2018.
 */
@Database(entities = arrayOf(MangaEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun mangaListDao(): MangaDao
}