package com.silverlotus.api.model

import com.beust.klaxon.Json

/**
 * Created by Gian Patrick Quintana on 2/21/2018.
 */
data class MangaModel(
        @Json(name = "i") val id: String = "",
        @Json(name = "t") var title: String = ""
)



