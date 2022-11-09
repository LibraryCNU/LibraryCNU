package com.collathon.librarycnu.shared.domain.usecase.student

import com.collathon.librarycnu.shared.domain.repository.StudentRepository

class LoginUseCase(private val repository: StudentRepository) {
    suspend fun execute(id: String, password: String): String =
        repository.login(id = id, password = password)
    suspend fun invoke(id: String, password: String): String =
        repository.login(id = id, password = password)
}
