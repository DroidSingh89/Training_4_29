package com.example.training_4_29.movieDb.model.data.remote

import com.example.training_4_29.movieDb.model.entities.MovieSearchResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET(MOVIE_SEARCH_PATH)
    fun movieListStream(
        @Query(MOVIE_QUERY_STRING) query: String,
        @Query(MOVIE_QUERY_PAGE) page: Int,
        @Query(MOVIE_QUERY_LANGUAGE) language: String
    ): Observable<MovieSearchResult>
}