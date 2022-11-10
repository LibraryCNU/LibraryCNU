package com.collathon.librarycnu.shared.data.storage

import com.collathon.librarycnu.shared.domain.entity.Student
import com.collathon.librarycnu.sqldelight.AppDB

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDB(databaseDriverFactory.createDriver())
    private val dbQuery = database.databaseQueries

    internal fun insertOrUpdateStudent(student: Student) {

    }
}
