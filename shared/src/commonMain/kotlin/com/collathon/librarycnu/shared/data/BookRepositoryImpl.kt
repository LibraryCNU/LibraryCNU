package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.domain.entity.Book
import com.collathon.librarycnu.shared.domain.repository.BookRepository

class BookRepositoryImpl : BookRepository {
    override suspend fun searchBook(query: String): List<Book> {
        TODO("Not yet implemented")
    }

}
