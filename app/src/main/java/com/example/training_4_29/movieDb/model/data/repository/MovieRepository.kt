package com.example.training_4_29.movieDb.model.data.repository

import com.example.training_4_29.movieDb.manager.CacheManager
import com.example.training_4_29.movieDb.model.data.DataSource
import com.example.training_4_29.movieDb.model.data.local.LocalDataSource
import com.example.training_4_29.movieDb.model.data.remote.RemoteDataSource
import com.example.training_4_29.movieDb.model.entities.movie.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    val remoteDataSource: RemoteDataSource, val localDataSource: LocalDataSource
) : MovieRepositoryContract {

    fun currentDataSource(): DataSource = if (CacheManager.isCacheDirty()) remoteDataSource else localDataSource

    override fun getMovieList(callback: (List<Movie>) -> Unit) {
        currentDataSource().getMovieList {
            if (CacheManager.isCacheDirty()) localDataSource.saveMovieList(movieList = it) {}
            callback.invoke(it)
        }
    }

    override fun saveMovieList(movieList: List<Movie>, callback: (Boolean) -> Unit) {
        localDataSource.saveMovieList(movieList) { callback(it) }
    }


}