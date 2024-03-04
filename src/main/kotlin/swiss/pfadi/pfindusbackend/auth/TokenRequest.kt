import com.fasterxml.jackson.annotation.JsonProperty

data class TokenRequest(
    @JsonProperty("grant_type") val grantType: String,
    @JsonProperty("client_id") val clientId: String,
    @JsonProperty("client_secret") val clientSecret: String,
    @JsonProperty("redirect_uri") val redirectUri: String,
    val code: String
)
