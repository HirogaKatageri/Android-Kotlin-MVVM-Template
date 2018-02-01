package com.silverlotus.kmvvm.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.livedata.liveDataResponse

/**
 * Created by Gian Patrick Quintana on 2/1/2018.
 */

const val IP_ADDRESS = 0

class Api {

    companion object {

        val hashResults = HashMap<Int, LiveData<Result>>()

        fun request(api: Fuel.RequestConvertible): Request {

            //Configure your request here
            return Fuel.request(api)
                    .timeout(30000)
        }

        fun getIpAddress(): LiveData<Result> {
            hashResults.put(IP_ADDRESS, Transformations.map(request(IpAddressApi.MyIp()).liveDataResponse(), { pair ->

                val result = Result()

                pair.second.fold({ value ->
                    result.isSuccessful = true
                    result.jsonString = String(value)
                }, { error ->
                    result.isSuccessful = false
                    result.errorMessage = String(error.response.data)
                })
                result
            }))

            return hashResults[IP_ADDRESS]!!
        }

    }

}