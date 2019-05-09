package quickr.stravaimporter.internal.client

import feign.Headers
import feign.Param
import feign.RequestLine
import quickr.stravaimporter.api.athlete.AthleteStats

@Headers(
    "Content-Type: application/json",
    "Authorization: Bearer {access_token}"
)
internal interface AthletesClient {

    @RequestLine("GET /athletes/{id}/stats")
    fun getAthleteStats(@Param("access_token") accessToken: String, @Param("id") id: Number): AthleteStats
}