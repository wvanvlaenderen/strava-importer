package quickr.stravaimporter.internal.service

import quickr.stravaimporter.api.athlete.AthleteStats
import quickr.stravaimporter.api.athlete.AthletesService
import quickr.stravaimporter.internal.auth.AuthService
import quickr.stravaimporter.internal.client.AthletesClient

internal class AthletesServiceImpl(val url: String, val authService: AuthService) : BaseService(), AthletesService {

    override fun getStats(id: Number): AthleteStats =
        buildClient(AthletesClient::class.java, url).getAthleteStats(authService.getAccessToken().accessToken, id)

}