package com.collathon.librarycnu.shared.domain.entity

data class Student (
    val id: String,
    val password: String,
    val studentId: String,
    val department: String,
    val name: String,
    val isAttending: String,
//    val session: String?,
    val qrInfo: String?,
)
