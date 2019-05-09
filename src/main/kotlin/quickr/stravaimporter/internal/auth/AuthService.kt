package quickr.stravaimporter.internal.auth

import quickr.stravaimporter.internal.client.AuthClient
import quickr.stravaimporter.internal.service.BaseService.Companion.buildClient

open class AuthService(
    var clientId: String,
    var clientSecret: String,
    var refreshToken: String
) {
    private val STRAVA_OAUTH_URL = "https://www.strava.com/oauth"

    open fun getAccessToken(): Token {
        return buildClient(AuthClient::class.java, STRAVA_OAUTH_URL)
            .postToken(
                mapOf(
                    "client_id" to clientId,
                    "client_secret" to clientSecret,
                    "grant_type" to GrantType.REFRESH_TOKEN.value,
                    "refresh_token" to refreshToken
                )
            )
    }
}