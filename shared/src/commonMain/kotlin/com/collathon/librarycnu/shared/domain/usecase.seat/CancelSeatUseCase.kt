package com.collathon.librarycnu.shared.domain.usecase.seat

import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class CancelSeatUseCase(private val repository: SeatRepository) {
    suspend fun execute(id: Int, place: String): Boolean =
        repository.cancelSeat(id = id, place = place)
    suspend fun invoke(id: Int, place: String): Boolean =
        repository.cancelSeat(id = id, place = place)
}
