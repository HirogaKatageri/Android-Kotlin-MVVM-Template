package com.silverlotus.api.data

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.core.ResponseDeserializable

/**
 * Created by Gian Patrick Quintana on 2/19/2018.
 */
data class MangaListData(
        @Json(name = "manga") val listOfMangaData: List<MangaData> = listOf()
) {
    class Deserializer : ResponseDeserializable<MangaListData> {
        override fun deserialize(content: String) = Klaxon().parse<MangaListData>(content)
    }
}