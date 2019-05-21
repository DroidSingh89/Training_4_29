package com.example.training_4_29.di

import android.content.Context
import com.example.training_4_29.manager.LoginManager
import com.example.training_4_29.ui.activity.firebase.FirebasePresenter
import dagger.Module
import dagger.Provides


@Module
class FirebaseModule(val context: Context) {

    @Provides
    fun providesFirebasePresenter(loginManager: LoginManager): FirebasePresenter = FirebasePresenter(loginManager)

    @Provides
    fun providesLoginManager(): LoginManager = LoginManager(context)
}