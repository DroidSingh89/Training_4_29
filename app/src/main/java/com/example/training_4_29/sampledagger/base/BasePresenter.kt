package com.example.training_4_29.sampledagger.base

interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
}