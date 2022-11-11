package com.collathon.librarycnu.shared.domain.usecase.student

import com.collathon.librarycnu.shared.domain.repository.StudentRepository

class LogoutUseCase(private val repository: StudentRepository) {
    suspend fun execute(session: String): Boolean = repository.logout(session = session)
    suspend fun invoke(session: String): Boolean = repository.logout(session = session)
}
