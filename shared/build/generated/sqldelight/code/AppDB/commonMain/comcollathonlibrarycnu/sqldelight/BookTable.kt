package comcollathonlibrarycnu.sqldelight

import kotlin.Boolean
import kotlin.String

public data class BookTable(
  public val author: String,
  public val name: String,
  public val publish: String,
  public val isbn: String,
  public val language: String?,
  public val picture: String?,
  public val isFavorite: Boolean
) {
  public override fun toString(): String = """
  |BookTable [
  |  author: $author
  |  name: $name
  |  publish: $publish
  |  isbn: $isbn
  |  language: $language
  |  picture: $picture
  |  isFavorite: $isFavorite
  |]
  """.trimMargin()
}
