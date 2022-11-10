package com.collathon.librarycnu.shared.data.network

import com.collathon.librarycnu.shared.data.StudentDataSource
import com.collathon.librarycnu.shared.data.model.StudentModel

class StudentRemoteDataSource(private val studentApi: StudentApi) : StudentDataSource {
    override suspend fun login(id: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun logout(session: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchStudentInfo(id: String): StudentModel {
        return studentApi.getStudentInfo(id = id)
    }

}
