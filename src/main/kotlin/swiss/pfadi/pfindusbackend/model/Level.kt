package swiss.pfadi.pfindusbackend.model

import com.fasterxml.jackson.annotation.JsonValue

enum class Level(@get:JsonValue val value: String) {
    WOLFSSTUFE("Wolfsstufe"),
    PFADISTUFE("Pfadistufe"),
    PIOSTUFE("Piostufe"),
    ROVERSTUFE("Roverstufe");

    companion object {
        private val typeMap = Level.entries.associateBy { it.value }
    }
}
