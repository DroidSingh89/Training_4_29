package com.example.training_4_29

import android.app.Application
import com.example.training_4_29.manager.CloudManager
import com.example.training_4_29.manager.LoginManager

class TrainingApp: Application() {


    override fun onCreate() {
        super.onCreate()
        LoginManager.context = applicationContext
        CloudManager.context = applicationContext
    }
}