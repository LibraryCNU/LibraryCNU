package comcollathonlibrarycnu.sqldelight

import kotlin.Boolean
import kotlin.String

public data class SeatTable(
  public val id: String,
  public val place: String,
  public val canReserve: Boolean,
  public val isFavorite: Boolean
) {
  public override fun toString(): String = """
  |SeatTable [
  |  id: $id
  |  place: $place
  |  canReserve: $canReserve
  |  isFavorite: $isFavorite
  |]
  """.trimMargin()
}
