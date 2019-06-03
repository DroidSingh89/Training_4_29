package com.example.training_4_29.sampledagger.model


data class Book(val name: String, val author: String)
class BookRepository {

    fun getBookList(category: String): List<Book> {
        return (1..10).map { Book("Book $category No:$it", "AuthorName$it") }
    }

}