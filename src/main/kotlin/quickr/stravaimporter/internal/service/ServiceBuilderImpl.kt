package quickr.stravaimporter.internal.service

import quickr.stravaimporter.api.ServiceBuilder
import quickr.stravaimporter.api.athlete.AthletesService
import quickr.stravaimporter.api.athlete.LoggedInAthleteService
import quickr.stravaimporter.internal.auth.AuthService


open class ServiceBuilderImpl(
    var clientId: String? = null,
    var clientSecret: String? = null,
    var refreshToken: String? = null,
    var url: String? = null
) : ServiceBuilder() {

    override fun buildAthleteService(): LoggedInAthleteService = LoggedInAthleteServiceImpl(url!!, buildAuthService())
    override fun buildAthletesService(): AthletesService = AthletesServiceImpl(url!!, buildAuthService())

    fun clientId(clientId: String) = apply {
        this.clientId = clientId
    }

    fun clientSecret(clientSecret: String) = apply {
        this.clientSecret = clientSecret
    }

    fun refreshToken(refreshToken: String) = apply {
        this.refreshToken = refreshToken
    }

    fun url(url: String) = apply {
        this.url = url
    }

    fun build() = ServiceBuilderImpl(clientId, clientSecret, refreshToken, url)

    open fun buildAuthService() = AuthService(clientId!!, clientSecret!!, refreshToken!!)
}