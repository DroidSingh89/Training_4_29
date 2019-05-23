package com.example.training_4_29.movieDb.di.component

import com.example.training_4_29.movieDb.di.module.MovieListModule
import com.example.training_4_29.movieDb.ui.movielist.MovieListPresenter
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(MovieListModule::class))
interface MovieListComponent {
    fun injectIn(movieListPresenter: MovieListPresenter)
}