package com.example.training_4_29.sampledagger.di

import com.example.training_4_29.sampledagger.model.BookRepository
import com.example.training_4_29.sampledagger.ui.BookPresenter
import dagger.Module
import dagger.Provides

@Module
class BookModule {

    @Provides
    fun providesBookPresenter(bookRepository: BookRepository) = BookPresenter(bookRepository)

    @Provides
    fun providesBookRepository(): BookRepository = BookRepository()
}