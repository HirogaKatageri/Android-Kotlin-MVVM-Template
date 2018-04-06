package com.silverlotus.kmvvm.repository

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import com.silverlotus.api.Api
import com.silverlotus.kmvvm.base.BaseRepository
import com.silverlotus.kmvvm.room.dao.MangaDao
import com.silverlotus.kmvvm.room.entity.MangaEntity
import org.kodein.di.generic.instance

/**
 * Created by Gian Patrick Quintana on 2/22/2018.
 */

class MangaRepository(private val context: Context) : BaseRepository<MangaRepository>(context = context) {

    private val mangaDao by instance<MangaDao>()
    private val api by instance<Api>()

    val pagingConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .build()

    fun getMangaList(max: Int) = LivePagedListBuilder(mangaDao.getMangaList(max), pagingConfig).build()

    fun fetchMangaList() {
        api.getMangaList().observeForever({ result ->
            if (result != null) {
                val (data, error) = result
                if (data != null)
                    mangaDao.updateMangaList(MangaEntity.fromMangaList(data))
            }
        })
    }
}