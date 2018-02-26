package com.silverlotus.api.model

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.ResponseDeserializable

/**
 * Created by Gian Patrick Quintana on 2/19/2018.
 */
data class MangaListModel(
        @Json(name = "manga") val listOfMangaData: List<MangaModel> = listOf()
) {
    class Deserializer : ResponseDeserializable<MangaListModel> {
        override fun deserialize(content: String) = Klaxon().parse<MangaListModel>(content)
    }
}