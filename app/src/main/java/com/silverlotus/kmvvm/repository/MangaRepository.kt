package com.silverlotus.kmvvm.repository

import com.github.salomonbrys.kodein.instance
import com.silverlotus.api.Api
import com.silverlotus.kmvvm.room.dao.MangaDao
import com.silverlotus.kmvvm.room.entity.MangaEntity
import com.silverlotus.kmvvm.root.RootRepository

/**
 * Created by Gian Patrick Quintana on 2/22/2018.
 */

class MangaRepository : RootRepository<MangaRepository>() {

    private val mangaDao by injector.instance<MangaDao>()
    private val api by injector.instance<Api>()

    fun getMangaList() = mangaDao.getPagedMangaList()

    fun fetchMangaList() {
        api.getMangaList().observeForever({ result ->
            if (result != null) {
                val (data, error) = result
                if (data!=null)
                    mangaDao.updateMangaList(MangaEntity.fromMangaList(data))
            }
        })
    }
}