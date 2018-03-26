package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.github.salomonbrys.kodein.instance
import com.silverlotus.kmvvm.repository.MangaRepository
import com.silverlotus.kmvvm.room.entity.MangaEntity
import com.silverlotus.kmvvm.base.BaseViewModel

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainViewModel : BaseViewModel<MainViewModel>() {

    private val mangaRepository by injector.instance<MangaRepository>()

    private var liveDaoMangaEntity: LiveData<PagedList<MangaEntity>> = MutableLiveData()

    var isFirstLoad = true

    fun getMangaList(): LiveData<PagedList<MangaEntity>> {

        liveDaoMangaEntity = mangaRepository.getMangaList()

        return liveDaoMangaEntity
    }

    fun fetchMangaList() = mangaRepository.fetchMangaList()
}