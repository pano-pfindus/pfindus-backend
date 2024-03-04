package swiss.pfadi.pfindusbackend.auth

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email

@JsonIgnoreProperties(ignoreUnknown = true)
class Profile(
    val id: String,
    @field:Email val email: String,
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
    val nickname: String
) {
}
