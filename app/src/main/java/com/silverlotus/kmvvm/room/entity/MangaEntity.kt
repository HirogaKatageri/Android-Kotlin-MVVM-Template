package com.silverlotus.kmvvm.room.entity

import android.arch.paging.PositionalDataSource
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.silverlotus.api.data.MangaData
import com.silverlotus.api.data.MangaListData

/**
 * Created by Gian Patrick Quintana on 2/21/2018.
 */
@Entity(tableName = "manga_list")
class MangaEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = ""

    @ColumnInfo(name = "title")
    var title: String = ""

    fun fromMangaData(manga: MangaData): MangaEntity {
        id = manga.id
        title = manga.title
        return this
    }

    companion object {

        fun fromMangaList(mangaListData: MangaListData): List<MangaEntity> =
                mangaListData.listOfMangaData.map { data -> MangaEntity().fromMangaData(data) }

    }
}