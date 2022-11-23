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

class SeatApi {
    // @TODO write your HOST, PORT
    private val HOST: String = "192.168.0.4"
    private val PORT: String = "8000"

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
        val id: Int?,
        val place: String?
    )

    suspend fun getAllSeatInfo(): List<SeatModel> {
        val response: HttpResponse = httpClient.get("http://$HOST:$PORT/get_all_seat_info")

        val responseSeatList = response.body<List<SeatResponseModel>>()
        val seatModelList: ArrayList<SeatModel> = ArrayList<SeatModel>()

        for (seat in responseSeatList) {
            seatModelList.add(SeatModel(
                seat.id,
                seat.place,
                seat.plugExistence,
                seat.startTime.toLocalDateTime(),
                seat.endTime.toLocalDateTime(),
                seat.canReserve,
                seat.isFavorite
            ))
        }

        return seatModelList.toList()
    }

    suspend fun getSeatInfo(id: Int, place: String?): SeatModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/get_seat_info") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id, place = null))
        }

        val responseSeat: SeatResponseModel = response.body()

        return SeatModel(
            responseSeat.id,
            responseSeat.place,
            responseSeat.plugExistence,
            responseSeat.startTime.toLocalDateTime(),
            responseSeat.endTime.toLocalDateTime(),
            responseSeat.canReserve,
            responseSeat.isFavorite
        )
    }

    suspend fun reserveSeat(id: Int, place: String?): OperationResponseModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/reserve_seat") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id, place = place))
        }

        return response.body()
    }

    suspend fun cancelSeat(id: Int, place: String?): OperationResponseModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/cancel_seat") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id, place = place))
        }

        return response.body()
    }

    suspend fun extendSeat(id: Int, place: String?): OperationResponseModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/extend_seat") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id, place = place))
        }

        return response.body()
    }

    suspend fun getReservationInfo(id: Int, place: String?): ReservationModel {
        val response: HttpResponse = httpClient.post("http://$HOST:$PORT/get_reservation_info") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody(id = id, place = place))
        }

        val responseReservation: ReservationResponseModel = response.body()

        return ReservationModel(
            responseReservation.startTime.toLocalDateTime(),
            responseReservation.endTime.toLocalDateTime(),
            responseReservation.canReserve
        )
    }
}
