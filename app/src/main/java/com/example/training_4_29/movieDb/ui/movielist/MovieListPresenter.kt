package com.example.training_4_29.movieDb.ui.movielist

import android.util.Log
import com.example.training_4_29.movieDb.model.data.repository.MovieRepository
import javax.inject.Inject

class MovieListPresenter @Inject constructor(val movieRepository: MovieRepository) :
    MovieListContract.Presenter {

    var view: MovieListContract.View? = null

    override fun getMovieList() {
        movieRepository.getMovieList {
            Log.d(MovieListPresenter::class.java.simpleName, "getMovieList: ${it.size}")
            view?.onMovieList(it)
        }
    }

    override fun attachView(view: MovieListContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}