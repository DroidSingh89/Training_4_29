package com.example.training_4_29.ui.base

interface BasePresenter<V: BaseView> {

    fun addView(view: V)
    fun removeView()

}