package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.model.BookModel

interface BookDataSource {
    suspend fun searchBook(query: String): List<BookModel> {
        TODO("Not yet implemented")
    }
}
