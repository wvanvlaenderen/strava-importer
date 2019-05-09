package quickr.stravaimporter

import io.netty.handler.codec.http.HttpMethod.GET
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.mockserver.client.MockServerClient
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import org.mockserver.model.HttpStatusCode.OK_200
import java.io.File
import java.io.IOException

abstract class HttpTest {

    private val MOCK_DATA_PAHT = "src/test/resources"
    private val port = 8888

    val url = "http://localhost:$port"

    var mockServer: MockServerClient = MockServerClient("localhost", port)

    @BeforeEach
    fun beforeAll() {
        mockServer = ClientAndServer.startClientAndServer(port)
        loadMockData()
    }

    private fun loadMockData() {
        File(MOCK_DATA_PAHT).listFiles().forEach {
            mockServer.setup(
                GET.name(),
                it.nameWithoutExtension.replace("_", "/"),
                OK_200.code(),
                getResourceAsText(it.name)
            )
        }
    }

    @AfterEach
    fun afterAll() {
        mockServer.close()
    }

    @Throws(IOException::class)
    internal fun getResourceAsText(path: String): String {
        return object {}.javaClass.getResource("/" + path).readText()
    }

    internal fun MockServerClient.setup(
        requestMethod: String,
        requestPath: String,
        responseStatus: Int,
        responseBody: String
    ) {
        this.`when`(
            HttpRequest.request()
                .withMethod(requestMethod)
                .withPath("/" + requestPath)
        )
            .respond(
                HttpResponse.response()
                    .withStatusCode(responseStatus)
                    .withBody(responseBody)
            )
    }

    internal fun MockServerClient.verifyRequest(
        method: String? = GET.name(),
        path: String?
    ) {
        val request = HttpRequest.request()
        method?.let { request.withMethod(method) }
        path?.let { request.withPath(path) }
        this.verify(request)
    }
}