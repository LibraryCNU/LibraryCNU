package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.model.StudentModel

interface StudentDataSource {
    suspend fun login(id: String, password: String): String
    suspend fun logout(session: String): Boolean
    suspend fun fetchStudentInfo(id: String): StudentModel
}
