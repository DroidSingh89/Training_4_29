package com.example.training_4_29.sampledagger.di

import com.example.training_4_29.sampledagger.ui.BookActivity
import dagger.Component

@Component(modules = [BookModule::class])
interface BookComponent{

    fun inject(bookActivity: BookActivity)
}