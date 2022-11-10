package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.domain.entity.Student
import com.collathon.librarycnu.shared.domain.repository.StudentRepository

class StudentRepositoryImpl(
    private val localStudentDataSource: StudentDataSource,
    private val remoteStudentDataSource: StudentDataSource
) : StudentRepository {
    override suspend fun login(id: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(session: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchStudentInfo(id: String): Student {
        val studentModel = remoteStudentDataSource.fetchStudentInfo(id = id)
        return Student(
            studentModel.id,
            studentModel.password,
            studentModel.studentId,
            studentModel.department,
            studentModel.name,
            studentModel.isAttending,
            studentModel.qr
        )
    }

}
