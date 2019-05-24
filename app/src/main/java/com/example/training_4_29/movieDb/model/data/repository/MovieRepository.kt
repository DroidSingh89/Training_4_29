package com.example.training_4_29.movieDb.model.data.repository

import android.util.Log
import com.example.training_4_29.movieDb.manager.CacheManager
import com.example.training_4_29.movieDb.model.data.DataSource
import com.example.training_4_29.movieDb.model.data.local.LocalDataSource
import com.example.training_4_29.movieDb.model.data.remote.RemoteDataSource
import com.example.training_4_29.movieDb.model.entities.Result
import javax.inject.Inject

class MovieRepository @Inject constructor(
    val remoteDataSource: RemoteDataSource, val localDataSource: LocalDataSource
) : MovieRepositoryContract {

    fun currentDataSource(): DataSource = if (CacheManager.isCacheDirty()) remoteDataSource else localDataSource

    override fun getMovieList(callback: (List<Result>) -> Unit) {
        currentDataSource().getMovieList {
           // if (CacheManager.isCacheDirty()) localDataSource.saveMovieList(movieList = it) {}
            Log.d(MovieRepository::class.java.simpleName, "getMovieList: ${it.size}")
            callback.invoke(it)
        }
    }

    override fun saveMovieList(movieList: List<Result>, callback: (Boolean) -> Unit) {
        localDataSource.saveMovieList(movieList) { callback(it) }
    }


}