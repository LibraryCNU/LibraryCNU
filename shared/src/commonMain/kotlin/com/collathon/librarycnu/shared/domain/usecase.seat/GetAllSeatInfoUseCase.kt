package com.collathon.librarycnu.shared.domain.usecase.seat

import com.collathon.librarycnu.shared.domain.entity.Seat
import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class GetAllSeatInfoUseCase(private val repository: SeatRepository) {
    suspend fun execute(): List<Seat> = repository.fetchAllSeatInfo()
    suspend fun invoke(): List<Seat> = repository.fetchAllSeatInfo()
}
