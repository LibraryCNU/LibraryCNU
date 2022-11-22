package com.collathon.librarycnu.shared.domain.usecase.demo

import com.collathon.librarycnu.shared.domain.repository.DemoRepository

class SetSearchBookLEDUseCase(private val repository: DemoRepository) {
    suspend fun execute(id: Int, place: String): Unit =
        repository.setSearchBookLED()
    suspend fun invoke(id: Int, place: String): Unit =
        repository.setSearchBookLED()
}
