package com.collathon.librarycnu.shared.domain.usecase.student

import com.collathon.librarycnu.shared.domain.entity.Student
import com.collathon.librarycnu.shared.domain.repository.StudentRepository

class GetStudentInfoUseCase(private val repository: StudentRepository) {
    suspend fun execute(id: String): Student = repository.fetchStudentInfo(id = id)
    suspend fun invoke(id: String): Student = repository.fetchStudentInfo(id = id)
}
