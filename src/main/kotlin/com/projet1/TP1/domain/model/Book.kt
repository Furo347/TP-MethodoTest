package com.projet1.TP1.domain.model

class Book(val author: String, val title: String) {
    init {
        require(author.isNotBlank()) { "Author cannot be blank" }
        require(title.isNotBlank()) { "Title cannot be blank" }
    }
}