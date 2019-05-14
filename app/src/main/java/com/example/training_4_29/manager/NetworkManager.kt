package com.example.training_4_29.manager

import com.example.training_4_29.network.NativeHelper

object NetworkManager{
    enum class PROVIDER{NATIVE, OKHTTP, RETROFIT}

    val nativeUrl = "http://www.mocky.io/v2/5cdada32300000657868ca96"
    val OkhttpUrl = "http://www.mocky.io/v2/5cdada32300000657868ca96"

    val nativeHelper= NativeHelper()

    fun makeRequest(provider: NetworkManager.PROVIDER){

        when(provider){
            NetworkManager.PROVIDER.NATIVE -> nativeHelper.makeRequest(nativeUrl)
            else -> print("Invalid network provider")
        }
    }
}