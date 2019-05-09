package quickr.stravaimporter.api.athlete

import com.google.gson.Gson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import quickr.stravaimporter.HttpTest
import quickr.stravaimporter.MockServiceBuilder

class LoggedInAthleteServiceTest : HttpTest() {

    @Test
    fun `should return logged in athlete`() {
        val result = MockServiceBuilder(url).buildAthleteService().getLoggedInAthlete()
        val expectedAthlete = Gson().fromJson(getResourceAsText("athlete.json"), Athlete::class.java)

        assertThat(result).isEqualTo(expectedAthlete)

        mockServer.verifyRequest(path = "/athlete")
    }
}