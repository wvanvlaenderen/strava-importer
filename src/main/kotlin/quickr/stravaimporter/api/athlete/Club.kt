package quickr.stravaimporter.api.athlete

import com.google.gson.annotations.SerializedName

data class Club(
    @SerializedName("name")
    val name: String?
)