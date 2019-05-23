package com.example.training_4_29.movieDb.model.data.local

import com.example.training_4_29.movieDb.model.data.DataSource
import com.example.training_4_29.movieDb.model.entities.movie.Movie


class LocalDataSource : DataSource{
    override fun getMovieList(callback: (List<Movie>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveMovieList(movieList: List<Movie>, callback: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
