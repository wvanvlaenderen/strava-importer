package quickr.stravaimporter.api.athlete

interface AthletesService {
    fun getStats(id: Number): AthleteStats
}