package com.collathon.librarycnu.shared.data.storage

import com.collathon.librarycnu.shared.data.BookDataSource
import com.collathon.librarycnu.shared.data.model.BookModel

class BookLocalDataSource(private val database: Database) : BookDataSource {
    override suspend fun searchBook(query: String): List<BookModel> {
        TODO("not implemented.")
    }
}
