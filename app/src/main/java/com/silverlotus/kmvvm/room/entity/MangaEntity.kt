package com.silverlotus.kmvvm.room.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.silverlotus.api.model.MangaListModel
import com.silverlotus.api.model.MangaModel

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

    fun fromMangaData(manga: MangaModel): MangaEntity {
        id = manga.id
        title = manga.title
        return this
    }

    fun isTheSameAs(mangaEntity: MangaEntity): Boolean {
        return id == mangaEntity.id
    }

    fun areContentsTheSameAs(mangaEntity: MangaEntity): Boolean {
        return title == mangaEntity.title
    }

    companion object {

        fun fromMangaList(mangaListModel: MangaListModel): List<MangaEntity> =
                mangaListModel.listOfMangaData.map { data -> MangaEntity().fromMangaData(data) }

    }
}