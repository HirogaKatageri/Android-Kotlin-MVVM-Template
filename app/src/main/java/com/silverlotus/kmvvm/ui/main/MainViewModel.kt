package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.github.salomonbrys.kodein.instance
import com.silverlotus.kmvvm.repository.MangaRepository
import com.silverlotus.kmvvm.room.entity.MangaEntity
import com.silverlotus.kmvvm.root.RootViewModel

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainViewModel : RootViewModel<MainViewModel>() {

    private val mangaRepository by injector.instance<MangaRepository>()

    private var liveDaoManga: LiveData<List<MangaEntity>> = MutableLiveData()

    var isFirstLoad = true

    fun getMangaList(): LiveData<List<MangaEntity>> {

        liveDaoManga = mangaRepository.getMangaList()

        return liveDaoManga
    }

    fun fetchMangaList() = mangaRepository.fetchMangaList()
}