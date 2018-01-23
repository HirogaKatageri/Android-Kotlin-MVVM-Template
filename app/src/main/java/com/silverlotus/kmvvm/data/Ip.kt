package com.silverlotus.kmvvm.data

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import com.silverlotus.kmvvm.data.Ip.Companion.toIp

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 *
 * Klaxon will parse JSON and convert it into this data class.
 * @see toIp
 */
data class Ip(@Json val ip: String) {

    companion object {

        /**
         * Using Klaxon to parse JSON String into Ip data class.
         * */
        fun toIp(json: String): Ip? = Klaxon().parse<Ip>(json)
    }
}