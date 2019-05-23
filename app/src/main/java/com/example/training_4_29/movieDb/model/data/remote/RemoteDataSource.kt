package com.example.training_4_29.movieDb.model.data.remote

import android.annotation.SuppressLint
import com.example.training_4_29.movieDb.model.data.DataSource
import com.example.training_4_29.movieDb.model.entities.movie.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val service: RemoteService) : DataSource {

    @SuppressLint("CheckResult")
    override fun getMovieList(callback: (List<Movie>) -> Unit) {
        service.movieListStream("godfather", 1, "en_US")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(callback)
    }

    override fun saveMovieList(movieList: List<Movie>, callback: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}