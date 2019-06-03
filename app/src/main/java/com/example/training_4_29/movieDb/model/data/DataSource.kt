package com.example.training_4_29.movieDb.model.data

import com.example.training_4_29.movieDb.model.entities.Result

interface DataSource {

    fun getMovieList(callback: (List<Result>) -> Unit)
    fun saveMovieList(movieList: List<Result>, callback: (Boolean) -> Unit)

}