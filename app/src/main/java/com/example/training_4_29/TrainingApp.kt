package com.example.training_4_29

import android.app.Application
import android.content.Context
import com.example.training_4_29.di.DaggerFirebaseComponent
import com.example.training_4_29.di.FirebaseModule
import com.example.training_4_29.manager.CloudManager

class TrainingApp: Application() {

    val firebaseComponent by lazy {
        DaggerFirebaseComponent.builder()
            .firebaseModule(FirebaseModule(applicationContext))
            .build()
    }

    companion object{
        fun get(context: Context): TrainingApp = context.applicationContext as TrainingApp
    }

    override fun onCreate() {
        super.onCreate()
        CloudManager.context = applicationContext
    }
}