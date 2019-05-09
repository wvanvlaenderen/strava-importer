package quickr.stravaimporter.internal.client

import feign.Headers
import feign.Param
import feign.RequestLine
import quickr.stravaimporter.api.athlete.Athlete

@Headers(
    "Content-Type: application/json",
    "Authorization: Bearer {access_token}"
)
internal interface LoggedInAthleteClient {

    @RequestLine("GET /athlete")
    fun getAthlete(@Param("access_token") accessToken: String): Athlete

}