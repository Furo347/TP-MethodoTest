package com.projet1.TP1.domain.port

interface BookRepositoryPort {
    fun saveBook(book: com.projet1.TP1.domain.model.Book): Boolean
}