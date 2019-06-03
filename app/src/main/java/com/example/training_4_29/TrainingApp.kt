package com.example.training_4_29


import android.app.Application
import android.content.Context
import com.example.training_4_29.di.DaggerFirebaseComponent
import com.example.training_4_29.di.FirebaseModule
import com.example.training_4_29.manager.AnalyticsManager
import com.example.training_4_29.manager.CloudManager
import com.example.training_4_29.movieDb.di.component.ApplicationComponent
import com.example.training_4_29.movieDb.di.component.DaggerApplicationComponent
import com.example.training_4_29.movieDb.di.component.MovieListComponent
import com.example.training_4_29.movieDb.di.module.AppModule


class TrainingApp : Application() {

    companion object {
        fun get(context: Context): TrainingApp = context.applicationContext as TrainingApp
    }

    lateinit var appComponent: ApplicationComponent
    var movieListComponent: MovieListComponent? = null
    val firebaseComponent by lazy {
        DaggerFirebaseComponent.builder()
            .firebaseModule(FirebaseModule(applicationContext))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        CloudManager.context = applicationContext
        AnalyticsManager.init(this)



        appComponent = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()

    }

    fun createMovieListComponent(): MovieListComponent? = appComponent.movieListComponent()

    fun clearMovieListComponent() {
        movieListComponent = null
    }

}