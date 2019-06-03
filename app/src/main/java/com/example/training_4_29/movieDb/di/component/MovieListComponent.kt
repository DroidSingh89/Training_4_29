package com.example.training_4_29.movieDb.di.component

import com.example.training_4_29.movieDb.di.module.MovieListModule
import com.example.training_4_29.movieDb.ui.movielist.MovieListActivity
import dagger.Subcomponent

@Subcomponent(modules = [MovieListModule::class])
interface MovieListComponent {
    fun injectIn(movieListActivity: MovieListActivity)
    //fun movieListActivity(): MovieListActivity
}