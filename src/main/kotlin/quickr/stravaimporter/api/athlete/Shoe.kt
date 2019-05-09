package quickr.stravaimporter.api.athlete

import com.google.gson.annotations.SerializedName

data class Shoe(
    @SerializedName("name")
    val name: String?
)