package quickr.stravaimporter.api.athlete

import com.google.gson.annotations.SerializedName

data class AthleteStats(
    @SerializedName("ytd_swim_totals")
    val ytd_swim_totals: Any,

    @SerializedName("ytd_ride_totals")
    val ytd_ride_totals: Any,

    @SerializedName("ytd_run_totals")
    val ytd_run_totals: Any
)

