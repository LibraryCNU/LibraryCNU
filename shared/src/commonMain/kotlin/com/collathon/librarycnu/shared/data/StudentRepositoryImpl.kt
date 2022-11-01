package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.domain.entity.Student
import com.collathon.librarycnu.shared.domain.repository.StudentRepository

class StudentRepositoryImpl : StudentRepository {
    override suspend fun login(id: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(session: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchStudentInfo(session: String): List<Student> {
        TODO("Not yet implemented")
    }

}
