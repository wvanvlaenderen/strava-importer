package quickr.stravaimporter.api

import quickr.stravaimporter.api.athlete.AthletesService
import quickr.stravaimporter.api.athlete.LoggedInAthleteService
import quickr.stravaimporter.internal.service.ServiceBuilderImpl


abstract class ServiceBuilder {
    companion object {
        private val STRAVA_API_URL = "https://www.strava.com/api/v3"

        @JvmStatic
        fun build(clientId: String, clientSecret: String, refreshToken: String) = build(clientId, clientSecret, refreshToken, STRAVA_API_URL)

        fun build(clientId: String, clientSecret: String, refreshToken: String, url: String): ServiceBuilder =
            ServiceBuilderImpl()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .refreshToken(refreshToken)
                .url(url)
                .build()
    }

    abstract fun buildAthleteService(): LoggedInAthleteService

    abstract fun buildAthletesService(): AthletesService
}