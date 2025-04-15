package com.projet1.TP1.domain.usecase

import com.projet1.TP1.domain.model.Book
import com.projet1.TP1.usecase.BookMethods
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BookMethodsTest {

    @Test
    fun `createBook doit créer un livre avec les bonnes propriétés`() {
        val bookMethods = BookMethods()
        val book = bookMethods.createBook("J.K. Rowling", "Harry Potter")

        assertEquals("J.K. Rowling", book.author)
        assertEquals("Harry Potter", book.title)
    }

    @Test
    fun `getAllBooksSortedByTitle doit retourner une liste triée par titre`() {
        val bookMethods = BookMethods()
        val books = listOf(
            Book("Author A", "Zebra"),
            Book("Author B", "Apple"),
            Book("Author C", "Monkey")
        )

        val sortedBooks = bookMethods.getAllBooksSortedByTitle(books)

        assertEquals("Apple", sortedBooks[0].title)
        assertEquals("Monkey", sortedBooks[1].title)
        assertEquals("Zebra", sortedBooks[2].title)
    }
}