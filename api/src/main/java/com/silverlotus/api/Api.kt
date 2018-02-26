package com.silverlotus.api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.livedata.liveDataObject
import com.silverlotus.api.model.MangaListModel
import com.silverlotus.api.subapi.MangaEdenApi

/**
 * Created by Gian Patrick Quintana on 2/1/2018.
 */

class Api {

    private fun request(api: Fuel.RequestConvertible): Request {

        return Fuel.request(api)
                .timeout(30000)
    }

    fun getMangaList() = request(MangaEdenApi.MangaList()).liveDataObject(MangaListModel.Deserializer())
}