package swiss.pfadi.pfindusbackend.model


import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.http.HttpStatus
import swiss.pfadi.pfindusbackend.error.RequestException


enum class Canton(@get:JsonValue val value: String) {
    PFADI_AARGAU("Pfadi Aargau"),
    PFADI_REGION_BASEL("Pfadi Region Basel"),
    PFADI_KANTON_BERN("Pfadi Kanton Bern"),
    SCOUTS_FREIBURG_PFADI_FREIBURG("Scouts Freiburg / Pfadi Freiburg"),
    SCOUTS_GENEVE("Scouts Genève"),
    PFADI_GLARUS("Pfadi Glarus"),
    ASSOCIATION_DU_SCOUTISME_JURASSIEN_PFADI_JURA("Association du scoutisme jurassien / Pfadi Jura"),
    PFADI_LUZERN("Pfadi Luzern"),
    SCOUTISME_NEUCHATELOIS_PFADI_NEUENBURG("Scoutisme Neuchatelois / Pfadi Neuenburg"),
    PFADI_ST_GALLEN_APPENZELL("Pfadi St. Gallen-Appenzell"),
    PFADI_KANTONALVERBAND_SCHAFFHAUSEN("Pfadi Kantornalverband Schaffausen"),
    PFADI_SCHWYZ("Pfadi Schwyz"),
    PFADI_KANTON_SOLTHURN("Pfadi Kanton Solothurn"),
    SCOUTISMO_TICINO_PFADI_TESSIN("Scoutismo Ticino / Pfadi Tessin"),
    PFADI_THURGAU("Pfadi Thurgau"),
    PFADI_URI("Pfadi Uri"),
    PFADI_UNDARWALDEN("Pfadi Undärwalden (Ob-und Nidwalden)"),
    ASSOCIATION_DU_SCOUTISME_VALAISAN_VERBAND_PFADI_WALLIS("Association du scoutisme valaisan / Verband Pfadi Wallis"),
    ASSOCIATION_DU_SCOUTISME_VAUDOIS_PFADI_WAADT("Association du scoutisme vaudois / Pfadi Waadt"),
    PFADI_KANTON_ZUG("Pfadi Kanton Zug"),
    PFADI_ZURI("Pfadi Züri"),
    BATTASENDAS_PFADI_GRAUBUNDEN("Battasendas / Pfadi Graubünden");

    companion object {
        private val typeMap = Canton.entries.associateBy { it.value }

        fun fromString(value: String): Canton {
            return typeMap[value] ?: throw RequestException("Unknown Canton: $value", HttpStatus.BAD_REQUEST)
        }
    }

}
