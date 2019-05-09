package quickr.stravaimporter.internal.client

import feign.Headers
import feign.RequestLine
import quickr.stravaimporter.internal.auth.Token

@Headers(
    "Content-Type: application/json"
)
internal interface AuthClient {

    @RequestLine("POST /token")
    fun postToken(body: Map<String, String>): Token

}
