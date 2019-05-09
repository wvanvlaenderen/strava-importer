package quickr.stravaimporter

import quickr.stravaimporter.internal.service.ServiceBuilderImpl

class MockServiceBuilder(url: String) : ServiceBuilderImpl("", "", "", url) {
    override fun buildAuthService() = MockAuthService()
}