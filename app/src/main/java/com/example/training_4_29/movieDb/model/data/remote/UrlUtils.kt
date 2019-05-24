package com.example.training_4_29.movieDb.model.data.remote

import com.example.training_4_29.BuildConfig
import okhttp3.Interceptor


//Url builder
const val MOVIE_BASE_URL = "https://api.themoviedb.org/"
const val MOVIE_SEARCH_PATH = "3/search/movie"
const val MOVIE_DISCOVER_PATH = "3/search/discover"

//Query builder
const val MOVIE_QUERY_API = "api_key"
const val MOVIE_QUERY_LANGUAGE = "language"
const val MOVIE_QUERY_STRING = "query"
const val MOVIE_QUERY_PAGE = "page"

val MOVIE_INTERCEPTOR = Interceptor { chain ->
    val original = chain.request()
    val originalHTTPURL = original.url()
    val url = originalHTTPURL.newBuilder()
        .addQueryParameter("api_key", BuildConfig.MOVIE_API_KEY)
        .build()

    val request = original.newBuilder()
        .url(url)
        .build()
    chain.proceed(request)
}