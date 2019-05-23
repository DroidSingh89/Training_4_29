package com.example.training_4_29.movieDb.di.component

import com.example.training_4_29.movieDb.di.module.DataModule
import com.example.training_4_29.movieDb.di.module.NetworkModule
import dagger.Component

@Component(modules = arrayOf(NetworkModule::class, DataModule::class))
interface DataComponent {

    fun injectIn(movieListComponent: MovieListComponent)

}