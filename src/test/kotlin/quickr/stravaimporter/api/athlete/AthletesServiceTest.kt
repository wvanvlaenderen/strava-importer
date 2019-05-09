package quickr.stravaimporter.api.athlete

import com.google.gson.Gson
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import quickr.stravaimporter.HttpTest
import quickr.stravaimporter.MockServiceBuilder

class AthletesServiceTest : HttpTest() {

    @Test
    fun `should return stats for athlete`() {
        val result = MockServiceBuilder(url).buildAthletesService().getStats(1)
        val expectedAthlete = Gson().fromJson(getResourceAsText("athletes_1_stats.json"), AthleteStats::class.java)

        assertThat(result).isEqualTo(expectedAthlete)

        mockServer.verifyRequest(path = "/athletes/1/stats")
    }
}