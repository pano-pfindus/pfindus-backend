package swiss.pfadi.pfindusbackend.model

import com.fasterxml.jackson.annotation.JsonValue

enum class CampType(@get:JsonValue val value: String) {
    HAUSLAGER("Hauslager"),
    ZELTLAGER("Zeltlager"),
    BEIDES("Beides"),
    EGAL("Egal");
}
