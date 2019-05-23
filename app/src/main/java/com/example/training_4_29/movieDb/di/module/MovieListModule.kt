package com.example.training_4_29.movieDb.di.module

import com.example.training_4_29.movieDb.model.data.repository.MovieRepository
import com.example.training_4_29.movieDb.ui.movielist.MovieListPresenter
import dagger.Module
import dagger.Provides

@Module
class MovieListModule {

    @Provides
    fun providesMovieListPresenter(movieRepository: MovieRepository) = MovieListPresenter(movieRepository)

}