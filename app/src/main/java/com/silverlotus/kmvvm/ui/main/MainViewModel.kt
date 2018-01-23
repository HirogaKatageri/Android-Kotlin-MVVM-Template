package com.silverlotus.kmvvm.ui.main

import android.arch.lifecycle.*
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.livedata.liveDataResponse
import com.github.kittinunf.result.success
import com.silverlotus.kmvvm.api.IpAddressApi
import com.silverlotus.kmvvm.data.Ip

/**
 * Created by Gian Patrick Quintana on 1/22/2018.
 */
class MainViewModel : ViewModel() {

    private var ipAddress = MutableLiveData<String>()
    private lateinit var owner: LifecycleOwner
    private lateinit var view: MainView

    fun attach(fragment: MainFragment) {
        owner = fragment
        view = fragment
    }

    fun fetchMyIp(): LiveData<String> {

        Fuel.request(IpAddressApi.myIp())
                .liveDataResponse()
                .observe(owner, Observer {

                    if (it?.first?.statusCode == 200) {//If you want you can add a status code checker here.

                        it.second.success {
                            val ip = Klaxon().parse<Ip>(String(it))
                            ipAddress.value = ip?.ip
                        }
                    }
                })
        return ipAddress
    }

}