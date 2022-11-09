package com.collathon.librarycnu.shared.domain.repository

import com.collathon.librarycnu.shared.domain.entity.Book

interface BookRepository {
    suspend fun searchBook(query: String): List<Book>
    // Need more considers.
}
