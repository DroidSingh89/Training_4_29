package com.example.training_4_29.movieDb.di.module

import com.example.training_4_29.movieDb.model.data.local.LocalDataSource
import com.example.training_4_29.movieDb.model.data.remote.RemoteDataSource
import com.example.training_4_29.movieDb.model.data.remote.RemoteService
import com.example.training_4_29.movieDb.model.data.repository.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesMovieRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) =
        MovieRepository(remoteDataSource, localDataSource)

    @Provides
    fun providesRemoteDataSource(remoteService: RemoteService) = RemoteDataSource(remoteService)

    @Provides
    fun providesLocalDataSource() = LocalDataSource()
}