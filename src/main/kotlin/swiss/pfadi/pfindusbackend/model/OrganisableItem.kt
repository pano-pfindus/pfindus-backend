package swiss.pfadi.pfindusbackend.model

import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus
import swiss.pfadi.pfindusbackend.error.RequestException

enum class OrganisableItem(@get:JsonValue val value: String) {
    LAGERHAUS("Lagerhaus"),
    ZELTPLATZ("Zeltplatz"),
    KÜCHENTEAM("Küchenteam");

    companion object {
        private val typeMap = OrganisableItem.entries.associateBy { it.value }

        fun fromString(value: String): OrganisableItem {
            return typeMap[value] ?: throw RequestException("Unknown OrganisableItem: $value", HttpStatus.BAD_REQUEST)
        }
    }
}
