package com.silverlotus.api.sub

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

/**
 * Created by Gian Patrick Quintana on 2/19/2018.
 */
sealed class MangaEdenApi : FuelRouting {

    class MangaList : MangaEdenApi()

    override val basePath: String = "https://www.mangaeden.com/"

    override val headers: Map<String, String>? = null

    override val method: Method
        get() {
            when (this) {
                is MangaList -> return Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            when (this) {
                is MangaList -> return null
            }
        }
    override val path: String
        get() {
            when (this) {
                is MangaList -> return "api/list/0/?p=0&l=25"
            }
        }
}