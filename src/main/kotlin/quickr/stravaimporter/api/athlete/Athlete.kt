package quickr.stravaimporter.api.athlete

import com.google.gson.annotations.SerializedName

data class Athlete(
    @SerializedName("id")
    val id: Number?,

    @SerializedName("username")
    val username: String?,

    @SerializedName("resource_state")
    val resourceState: Number?,

    @SerializedName("firstname")
    val firstname: String?,

    @SerializedName("lastname")
    val lastname: String?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("state")
    val state: String?,

    @SerializedName("country")
    val country: String?,

    @SerializedName("sex")
    val sex: String?,

    @SerializedName("premium")
    val premium: Boolean,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("updated_at")
    val updatedAt: String?,

    @SerializedName("badge_type_id")
    val badgeTypeId: Number?,

    @SerializedName("profile_medium")
    val profileMedium: String?,

    @SerializedName("profile")
    val profile: String?,

    @SerializedName("friend")
    val friend: String?,

    @SerializedName("follower")
    val follower: String?,

    @SerializedName("follower_count")
    val followerCount: Number?,

    @SerializedName("friend_count")
    val friendCount: Number?,

    @SerializedName("mutual_friend_count")
    val mutualFriendCount: Number?,

    @SerializedName("athlete_type")
    val athleteType: Number?,

    @SerializedName("date_preference")
    val datePreference: String?,

    @SerializedName("measurement_preference")
    val measurementPreference: String?,

    @SerializedName("clubs")
    val clubs: List<Club>,

    @SerializedName("ftp")
    val ftp: Number?,

    @SerializedName("weight")
    val weight: Number?,

    @SerializedName("bikes")
    val bikes: List<Bike>,

    @SerializedName("shoes")
    val shoes: List<Shoe>

)
