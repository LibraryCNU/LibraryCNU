package com.collathon.librarycnu.shared.domain.usecase.demo

import com.collathon.librarycnu.shared.domain.repository.DemoRepository

class SetReserveSeatLEDUseCase(private val repository: DemoRepository) {
    suspend fun execute(): Unit =
        repository.setReserveSeatLED()
    suspend fun invoke(): Unit =
        repository.setReserveSeatLED()
}
