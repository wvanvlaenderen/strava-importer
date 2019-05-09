package quickr.stravaimporter.internal.service

import quickr.stravaimporter.api.athlete.LoggedInAthleteService
import quickr.stravaimporter.internal.auth.AuthService
import quickr.stravaimporter.internal.client.LoggedInAthleteClient

internal class LoggedInAthleteServiceImpl(val url: String, val authService: AuthService) : BaseService(), LoggedInAthleteService {

    override fun getLoggedInAthlete() =
        buildClient(LoggedInAthleteClient::class.java, url).getAthlete(authService.getAccessToken().accessToken)
}