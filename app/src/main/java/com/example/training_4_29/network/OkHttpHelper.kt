package com.example.training_4_29.network

import okhttp3.*
import java.io.IOException

class OkHttpHelper {

    val client = OkHttpClient()

    private fun buildRequest():Request{
        val httpUrl = HttpUrl.Builder()
            .scheme("https")
            .host("randomuser.me")
            .addPathSegment("api")
            .addQueryParameter("results", "10")
            .build()

        val request = Request.Builder()
            .url(httpUrl)
            .build()
        return request
    }
    fun makeSyncRequest(){

        client.newCall(buildRequest()).execute()
    }

    fun makeAsyncRequest(){
        client.newCall(buildRequest()).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}