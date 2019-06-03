package com.example.training_4_29.sampledagger.ui

import com.example.training_4_29.sampledagger.base.BasePresenter
import com.example.training_4_29.sampledagger.base.BaseView
import com.example.training_4_29.sampledagger.model.Book

interface BookContract {

    interface View: BaseView{

        fun onBooksLoaded(bookList: List<Book>)
    }

    interface Presenter: BasePresenter<View>{

        fun getBookList(category: String)
    }
}