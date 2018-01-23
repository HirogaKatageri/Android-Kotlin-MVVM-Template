package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.*
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.livedata.liveDataResponse
import com.github.kittinunf.result.success
import com.silverlotus.kmvvm.api.IpAddressApi
import com.silverlotus.kmvvm.data.Ip

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainViewModel : ViewModel() {

    private lateinit var ipAddress:LiveData<String>

    /**
     * ViewModel improved thanks to pskink's Suggestion on using LiveData Transformation. Since 2018/01/23
     *
     * For more information regarding Fuel Request using Fuel Routing and Live Data Response.
     * @see <a href="https://github.com/kittinunf/Fuel#routing-support">Fuel Routing Support</a>
     * @see <a href="https://github.com/kittinunf/Fuel#livedata-support">Fuel LiveData Support</a>
     * @see <a href="https://stackoverflow.com/users/2252830/pskink">pskink's</a> <a href="https://stackoverflow.com/questions/48396092/should-i-include-lifecycleowner-in-viewmodel#comment83784239_48396092"> suggestion on using LiveData Transformation</a>
     * */
    fun fetchMyIp(): LiveData<String> {

        ipAddress = Transformations.map(Fuel.request(IpAddressApi.MyIp()).liveDataResponse(), {

            var ip:String? = ""

                it.second.success {

                    ip = Ip.toIp(String(it))?.ip
                }
            ip
        })

        return ipAddress
    }

}