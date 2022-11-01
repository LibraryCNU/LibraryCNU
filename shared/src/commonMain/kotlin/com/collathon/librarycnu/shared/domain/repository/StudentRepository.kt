package com.collathon.librarycnu.shared.domain.repository

import com.collathon.librarycnu.shared.domain.entity.Student

interface StudentRepository {
    suspend fun login(id: String, password: String): String  // session
    suspend fun logout(session: String): Boolean
    suspend fun fetchStudentInfo(session: String): List<Student>
}
