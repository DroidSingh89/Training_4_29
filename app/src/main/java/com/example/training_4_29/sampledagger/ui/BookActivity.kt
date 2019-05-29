package com.example.training_4_29.sampledagger.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.training_4_29.R
import com.example.training_4_29.sampledagger.di.DaggerBookComponent
import com.example.training_4_29.sampledagger.model.Book
import javax.inject.Inject

class BookActivity : AppCompatActivity(), BookContract.View {

    @Inject
    lateinit var presenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        DaggerBookComponent.create().inject(this)



        presenter.attachView(this)
        presenter.getBookList("Science Fiction")

    }

    override fun onBooksLoaded(bookList: List<Book>) {
        bookList.forEach {
            Log.d(BookActivity::class.java.simpleName, "onBooksLoaded: $it")
        }
    }

    override fun showError(error: String) {

    }
}
