package com.silverlotus.kmvvm.repository

import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.github.salomonbrys.kodein.instance
import com.silverlotus.api.Api
import com.silverlotus.kmvvm.room.dao.MangaDao
import com.silverlotus.kmvvm.room.entity.MangaEntity
import com.silverlotus.kmvvm.base.BaseRepository

/**
 * Created by Gian Patrick Quintana on 2/22/2018.
 */

class MangaRepository : BaseRepository<MangaRepository>() {

    private val mangaDao by injector.instance<MangaDao>()
    private val api by injector.instance<Api>()

    val pagingConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setPrefetchDistance(10)
            .build()

    fun getMangaList() = LivePagedListBuilder(mangaDao.getPagedMangaList(), pagingConfig).build()

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