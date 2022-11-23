package com.collathon.librarycnu.shared.data.network

import OperationResponseModel
import ReservationResponseModel
import com.collathon.librarycnu.shared.data.model.ReservationModel
import com.collathon.librarycnu.shared.data.model.SeatModel
import com.collathon.librarycnu.shared.data.model.SeatResponseModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class DemoApi {
    // @TODO write your HOST, PORT
    private val HOST: String = "192.168.0.4"
    private val PORT: String = "8001"

    private val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun setReserveSeatLED(): Unit {
        val response: HttpResponse = httpClient.get("http://$HOST:$PORT/set_reserve_seat_led")
        return
    }

    suspend fun setSearchBookLED(): Unit {
        val response: HttpResponse = httpClient.get("http://$HOST:$PORT/set_search_book_led")
        return
    }
}
