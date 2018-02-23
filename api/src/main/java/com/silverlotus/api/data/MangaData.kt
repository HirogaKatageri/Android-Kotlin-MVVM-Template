package com.silverlotus.api.data

import com.beust.klaxon.Json

/**
 * Created by Gian Patrick Quintana on 2/21/2018.
 */
data class MangaData(
        @Json(name = "i") val id: String = "",
        @Json(name = "t") var title: String = ""
)



