package com.projet1.TP1.usecase

import com.projet1.TP1.domain.model.Book

class BookMethods {
    fun createBook(author: String, title: String): Book {
        return Book(author, title)
    }

    fun getAllBooksSortedByTitle(books: List<Book>): List<Book> {
        return books.sortedBy { it.title }
    }
}