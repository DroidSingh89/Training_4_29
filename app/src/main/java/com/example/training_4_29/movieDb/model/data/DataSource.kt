package com.example.training_4_29.movieDb.model.data

import com.example.training_4_29.movieDb.model.entities.movie.Movie

interface DataSource {

    fun getMovieList(callback: (List<Movie>) -> Unit)
    fun saveMovieList(movieList: List<Movie>, callback: (Boolean) -> Unit)

}