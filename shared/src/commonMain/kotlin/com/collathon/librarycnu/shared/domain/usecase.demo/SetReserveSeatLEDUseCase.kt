package com.collathon.librarycnu.shared.domain.usecase.demo

import com.collathon.librarycnu.shared.domain.repository.DemoRepository

class SetReserveSeatLEDUseCase(private val repository: DemoRepository) {
    suspend fun execute(id: Int, place: String): Unit =
        repository.setReserveSeatLED()
    suspend fun invoke(id: Int, place: String): Unit =
        repository.setReserveSeatLED()
}
