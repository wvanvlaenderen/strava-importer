package quickr.stravaimporter

import org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric
import quickr.stravaimporter.internal.auth.AuthService
import quickr.stravaimporter.internal.auth.Token

class MockAuthService : AuthService("", "", "") {

    override fun getAccessToken(): Token = Token(randomAlphanumeric(10))

}