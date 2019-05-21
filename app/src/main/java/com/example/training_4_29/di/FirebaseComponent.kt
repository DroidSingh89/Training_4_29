package com.example.training_4_29.di

import com.example.training_4_29.ui.activity.firebase.FirebaseActivity
import dagger.Component

@Component(modules = arrayOf(FirebaseModule::class))
interface FirebaseComponent {
    fun inject(activity: FirebaseActivity)
}