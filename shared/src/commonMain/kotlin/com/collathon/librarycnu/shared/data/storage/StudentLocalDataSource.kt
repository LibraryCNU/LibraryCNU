package com.collathon.librarycnu.shared.data.storage

import com.collathon.librarycnu.shared.data.StudentDataSource
import com.collathon.librarycnu.shared.data.model.StudentModel

class StudentLocalDataSource(private val database: Database) : StudentDataSource {
    override suspend fun login(id: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(session: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchStudentInfo(id: String): StudentModel {
        TODO("Not yet implemented")
    }

}
