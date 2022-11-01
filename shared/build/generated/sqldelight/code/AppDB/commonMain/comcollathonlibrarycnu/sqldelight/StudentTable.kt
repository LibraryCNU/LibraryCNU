package comcollathonlibrarycnu.sqldelight

import kotlin.String

public data class StudentTable(
  public val id: String,
  public val password: String,
  public val studentId: String,
  public val department: String,
  public val name: String,
  public val isAttending: String,
  public val session: String?,
  public val qrInfo: String?
) {
  public override fun toString(): String = """
  |StudentTable [
  |  id: $id
  |  password: $password
  |  studentId: $studentId
  |  department: $department
  |  name: $name
  |  isAttending: $isAttending
  |  session: $session
  |  qrInfo: $qrInfo
  |]
  """.trimMargin()
}
