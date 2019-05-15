package com.example.training_4_29.network

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.training_4_29.model.entities.RandomUser.RandomUserResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

class RetrofitHelper(val context: Context) {

    private val baseUrl = "https://randomuser.me/"
    private val path = "api"

    private val queryMap = HashMap<String, String>()
    private val cacheSize: Long = 10 * 1024 * 1024
    private val cache = Cache(context.cacheDir, cacheSize)
    private val okHttpClient = OkHttpClient.Builder()
        .cache(cache)
        .addInterceptor { chain ->
            var request = chain.request()
            request = request.newBuilder()
                .header("Cache-Control", "public, max-age=" + 5)
                .build()
            chain.proceed(request)
        }
        .build()

    private fun createClient(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createService(): RetrofitService {
        return createClient().create(RetrofitService::class.java)
    }


    private fun createClientWithRxjava(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createServiceWithRxjava(): RetrofitService {
        return createClientWithRxjava().create(RetrofitService::class.java)
    }


    fun getUserList(resultCount: String, callback: (RandomUserResponse) -> Unit) {

        queryMap.let {
            it["results"] = resultCount
            it["gender"] = "male"
            it.put("nat", "US")

        }
        createService().getUserList(path, queryMap).enqueue(object : Callback<RandomUserResponse> {
            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Log.d(RetrofitHelper::class.java.simpleName, "onFailure: ")
            }

            override fun onResponse(call: Call<RandomUserResponse>, response: Response<RandomUserResponse>) {
                Log.d(RetrofitHelper::class.java.simpleName, "onResponse: ${response.raw().cacheResponse()}")
                Log.d(RetrofitHelper::class.java.simpleName, "onResponse: ${response.raw().networkResponse()}")
                callback.invoke(response.body()!!)
            }

        })
    }


    @SuppressLint("CheckResult")
    fun getUserListObs(results: String, callback: (RandomUserResponse) -> Unit){
        val observer = object : Observer<RandomUserResponse>{
            override fun onComplete() {
                Log.d(RetrofitHelper::class.java.simpleName, "onComplete: ")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(RetrofitHelper::class.java.simpleName, "onSubscribe: ")
            }

            override fun onNext(t: RandomUserResponse) {
                Log.d(RetrofitHelper::class.java.simpleName, "onNext: ${t.results?.get(0)?.name?.first}")
                callback.invoke(t)
            }

            override fun onError(e: Throwable) {
                Log.d(RetrofitHelper::class.java.simpleName, "onError: $e")
            }

        }
        val observable = createServiceWithRxjava()
            .getUserListWithRxJava(results)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .publish()
            .autoConnect()

        observable.subscribe(observer)
        observable.subscribe{
            Log.d(RetrofitHelper::class.java.simpleName, "getUserListObs: ${it.results?.get(0)?.name?.first}")}

    }


    interface RetrofitService {

        @GET("{custompath}")
        fun getUserList(@Path("custompath") path: String, @QueryMap map: HashMap<String, String>): Call<RandomUserResponse>

        @GET("api")
        fun getUserListWithRxJava(@Query("results") results: String): Observable<RandomUserResponse>
    }
}