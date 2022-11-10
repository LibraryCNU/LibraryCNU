package com.collathon.librarycnu.shared.data.network

import com.collathon.librarycnu.shared.data.BookDataSource
import com.collathon.librarycnu.shared.data.model.BookModel

class BookRemoteDataSource(private val bookApi: BookApi) : BookDataSource {
    override suspend fun searchBook(query: String): List<BookModel> {
        return bookApi.searchBook(query = query)
    }
}
