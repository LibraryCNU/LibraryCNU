package com.collathon.librarycnu.shared.domain.usecase.seat

import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class ReserveSeatUseCase(private val repository: SeatRepository) {
    suspend fun execute(id: Int, place: String): Boolean =
        repository.reserveSeat(id = id, place = place)
    suspend fun invoke(id: Int, place: String): Boolean =
        repository.reserveSeat(id = id, place = place)
}
