package com.collathon.librarycnu.shared.domain.usecase.demo

import com.collathon.librarycnu.shared.domain.repository.DemoRepository

class SetSearchBookLEDUseCase(private val repository: DemoRepository) {
    suspend fun execute(): Unit =
        repository.setSearchBookLED()
    suspend fun invoke(): Unit =
        repository.setSearchBookLED()
}
