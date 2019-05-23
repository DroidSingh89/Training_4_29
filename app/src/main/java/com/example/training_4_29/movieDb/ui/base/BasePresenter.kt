package com.example.training_4_29.movieDb.ui.base

interface BasePresenter<V: BaseView> {

    fun attachView(view: BaseView)
    fun detachView()
}