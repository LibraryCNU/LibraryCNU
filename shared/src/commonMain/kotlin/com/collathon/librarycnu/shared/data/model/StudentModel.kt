
package com.collathon.librarycnu.shared.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StudentModel (  // @Todo fix serial name.
    @SerialName("id")
    val id: String,
    @SerialName("password")
    val password: String,
    @SerialName("student_id")
    val studentId: String,
    @SerialName("department")
    val department: String,
    @SerialName("name")
    val name: String,
    @SerialName("is_attending")
    val isAttending: String,
//    @SerialName("session")
//    val session: String,
    @SerialName("qr")
    val qrInfo: String,
)
