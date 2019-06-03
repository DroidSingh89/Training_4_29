package com.example.training_4_29.movieDb.ui.movielist

import com.example.training_4_29.movieDb.model.entities.Result
import com.example.training_4_29.movieDb.ui.base.BasePresenter
import com.example.training_4_29.movieDb.ui.base.BaseView

interface MovieListContract {

    interface View: BaseView{

        fun onMovieList(movieList: List<Result>)
    }

    interface Presenter: BasePresenter<View>{

        fun getMovieList()
    }
}