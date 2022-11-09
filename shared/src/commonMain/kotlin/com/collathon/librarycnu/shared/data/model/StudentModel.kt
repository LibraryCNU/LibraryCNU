package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudentModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: String,
    @SerialName("password")
    val password: String,
    @SerialName("studentId")
    val studentId: String,
    @SerialName("department")
    val department: String,
    @SerialName("name")
    val name: String,
    @SerialName("isAttending")
    val isAttending: String,
    @SerialName("session")
    val session: String,
    @SerialName("qrInfo")
    val qrInfo: String,
)
