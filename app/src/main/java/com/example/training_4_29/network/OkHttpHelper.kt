package com.example.training_4_29.network

import android.util.Log
import com.example.training_4_29.model.entities.RandomUser.RandomUserResponse
import com.example.training_4_29.utils.Parser
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

class OkHttpHelper {

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

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

    fun makeAsyncRequest(callback: (RandomUserResponse)-> Unit){

        client.newCall(buildRequest()).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d(OkHttpHelper::class.java.simpleName, "onFailure: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                val responseString = response.body()?.string()
                val randomUserResponse = Parser.gsonParser(responseString)
                Parser.nativeParser(responseString)
                callback.invoke(randomUserResponse)
            }

        })
    }

}