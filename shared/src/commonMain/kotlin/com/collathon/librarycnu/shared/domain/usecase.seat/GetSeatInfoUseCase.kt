package com.collathon.librarycnu.shared.domain.usecase.seat

import com.collathon.librarycnu.shared.domain.entity.Seat
import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class GetSeatInfoUseCase(private val repository: SeatRepository) {
    suspend fun execute(id: Int, place: String): Seat =
        repository.fetchSeatInfo(id = id, place = place)
    suspend fun invoke(id: Int, place: String): Seat =
        repository.fetchSeatInfo(id = id, place = place)
}
