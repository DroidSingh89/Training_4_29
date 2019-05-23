package com.example.training_4_29.movieDb.di.module

import com.example.training_4_29.movieDb.model.data.remote.MOVIE_INTERCEPTOR
import com.example.training_4_29.movieDb.model.data.remote.RemoteService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun providesNetworkClient(client: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun providesBaseClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(MOVIE_INTERCEPTOR)
            .build()
    }

    @Provides
    fun providesNetworkService(networkClient: Retrofit): RemoteService{
        return networkClient.create(RemoteService::class.java)
    }
}