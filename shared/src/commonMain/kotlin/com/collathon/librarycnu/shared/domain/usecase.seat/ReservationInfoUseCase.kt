package com.collathon.librarycnu.shared.domain.usecase.seat

import com.collathon.librarycnu.shared.domain.entity.ReservationInfo
import com.collathon.librarycnu.shared.domain.repository.SeatRepository

class ReservationInfoUseCase(private val repository: SeatRepository) {
    suspend fun execute(id: Int, place: String): ReservationInfo =
        repository.fetchReservationInfo(id = id, place = place)
    suspend fun invoke(id: Int, place: String): ReservationInfo =
        repository.fetchReservationInfo(id = id, place = place)
}
