package com.collathon.librarycnu.shared.data.network

import com.collathon.librarycnu.shared.data.model.BookModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


class BookApi {
    // @TODO write your HOST, PORT
    private val HOST: String = ""
    private val PORT: String = ""

    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun searchBook(query: String): List<BookModel> {
        TODO("impl. search book")
    }
}
