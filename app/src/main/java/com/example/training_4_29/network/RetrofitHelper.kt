package com.example.training_4_29.network

import android.util.Log
import com.example.training_4_29.model.entities.RandomUser.RandomUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

class RetrofitHelper {

    private val baseUrl = "https://randomuser.me/"
    private val path = "api"

    private val queryMap = HashMap<String, String>()

    private fun createClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createService(): RetrofitService{
        return createClient().create(RetrofitService::class.java)
    }

    fun getUserList(resultCount: String, callback: (RandomUserResponse)-> Unit){

        queryMap.let {
            it.put("results", resultCount)
            it.put("gender", "male")
            it.put("nat", "US")
        }
        createService().getUserList(path, queryMap).enqueue(object: Callback<RandomUserResponse>{
            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Log.d(RetrofitHelper::class.java.simpleName, "onFailure: ")
            }

            override fun onResponse(call: Call<RandomUserResponse>, response: Response<RandomUserResponse>) {
                callback.invoke(response.body()!!)
            }

        })
    }


    interface RetrofitService{

        @GET("{custompath}")
        fun getUserList(@Path("custompath") path: String, @QueryMap map: HashMap<String, String>): Call<RandomUserResponse>
    }
}