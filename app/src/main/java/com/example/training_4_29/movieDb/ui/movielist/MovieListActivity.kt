package com.example.training_4_29.movieDb.ui.movielist

import android.os.Bundle
import android.util.Log
import com.example.training_4_29.ui.base.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.TrainingApp
import com.example.training_4_29.movieDb.model.entities.Result
import javax.inject.Inject

class MovieListActivity : BaseActivity(), MovieListContract.View {

    @Inject
    lateinit var presenter: MovieListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        TrainingApp.get(this).createMovieListComponent()?.injectIn(this)

        presenter.attachView(this)
        presenter.getMovieList()
    }

    override fun onMovieList(movieList: List<Result>) {
        movieList.forEach {
            Log.d(MovieListActivity::class.java.simpleName, "onMovieList: ${it.title}") }
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
