package com.example.training_4_29.network

import com.example.training_4_29.model.entities.github.GithubRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RemoteDataSource {

    val baseUrl = "https://api.github.com"

    fun createClient(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createService(): RemoteService {
        return createClient().create(RemoteService::class.java)
    }

    fun getRepoList(username: String, callback: (List<GithubRepo>) -> Unit) {

        createService().getRepoList(username).enqueue(object : Callback<List<GithubRepo>> {
            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
                callback.invoke(response.body()!!)
            }
        })

    }

}

interface RemoteService {

    @GET("users/{username}/repos")
    fun getRepoList(@Path("username") username: String): Call<List<GithubRepo>>

}