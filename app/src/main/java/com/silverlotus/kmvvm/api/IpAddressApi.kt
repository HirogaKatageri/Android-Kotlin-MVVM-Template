package com.silverlotus.kmvvm.api

import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
sealed class IpAddressApi : FuelRouting {

    override val basePath: String = "https://api.ipify.org"

    class myIp : IpAddressApi()

    override val headers: Map<String, String>?
        get() = null

    override val method: Method
        get() {
            when (this) {
                is myIp -> return Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() = null

    override val path: String
        get() {
            return when (this) {
                is myIp -> "?format=json"
            }
        }
}