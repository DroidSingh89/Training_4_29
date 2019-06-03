package com.example.training_4_29.sampledagger.ui

import com.example.training_4_29.sampledagger.model.BookRepository

class BookPresenter(val bookRepository: BookRepository) : BookContract.Presenter {

    var view: BookContract.View? = null

    override fun getBookList(category: String) {
        view?.onBooksLoaded(bookRepository.getBookList(category))
    }

    override fun attachView(view: BookContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}