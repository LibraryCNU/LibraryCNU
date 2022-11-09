import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OperationResponseModel (  // @Todo fix serial name.
    @SerialName("result")
    val result: Boolean
)
