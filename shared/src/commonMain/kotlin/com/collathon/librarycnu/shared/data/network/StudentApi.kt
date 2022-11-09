
package com.collathon.librarycnu.shared.data.network

import com.collathon.librarycnu.shared.data.model.StudentModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class StudentApi {
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

    @Serializable
    data class RequestBody (
        val id: String?
    )

    suspend fun getStudentInfo(id: String): StudentModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/get_student_info") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id))
        }

        return response.body()
    }
}
