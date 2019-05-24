package com.example.training_4_29.movieDb.di.component

import com.example.training_4_29.movieDb.di.module.AppModule
import com.example.training_4_29.movieDb.di.module.DataModule
import com.example.training_4_29.movieDb.di.module.NetworkModule
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface ApplicationComponent {

    fun movieListComponent(): MovieListComponent?

}