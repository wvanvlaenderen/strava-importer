package quickr.stravaimporter.api.athlete

import com.google.gson.annotations.SerializedName

data class Bike(
    @SerializedName("name")
    val name: String?
)